package cooperation.weiyun;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ax;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.an;
import com.tencent.mobileqq.filemanager.util.d;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.e;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.migration.DataLineNTMsgMigrationUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeiyunAIOUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class WeiyunCallbackImpl implements com.tencent.mobileqq.weiyun.a {

        /* renamed from: a, reason: collision with root package name */
        public MqqHandler f391486a;

        /* renamed from: b, reason: collision with root package name */
        private Context f391487b;

        /* renamed from: c, reason: collision with root package name */
        private QQAppInterface f391488c;

        public WeiyunCallbackImpl(MqqHandler mqqHandler, Context context, QQAppInterface qQAppInterface) {
            this.f391486a = mqqHandler;
            this.f391487b = context;
            this.f391488c = qQAppInterface;
        }

        @Override // com.tencent.mobileqq.weiyun.a
        public void onError(int i3, final String str) {
            MqqHandler mqqHandler = this.f391486a;
            if (mqqHandler != null) {
                mqqHandler.sendMessageDelayed(mqqHandler.obtainMessage(104, i3, 0, str), 1500L);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(WeiyunCallbackImpl.this.f391487b, 1, str, 1).show(WeiyunAIOUtils.a());
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.weiyun.a
        public void onSuccess(Object obj) {
            an.j();
            MqqHandler mqqHandler = this.f391486a;
            if (mqqHandler != null) {
                mqqHandler.sendEmptyMessageDelayed(103, 1500L);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BaseActivity.sTopActivity != null) {
                            ((IWeiyunSaveTipsHelper) QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(WeiyunCallbackImpl.this.f391488c, BaseActivity.sTopActivity, WeiyunAIOUtils.a());
                        } else {
                            QQToast.makeText(WeiyunCallbackImpl.this.f391487b, 2, R.string.em5, 1).show(WeiyunAIOUtils.a());
                        }
                    }
                });
            }
        }
    }

    static /* bridge */ /* synthetic */ int a() {
        return c();
    }

    private static int c() {
        Resources resources;
        BaseApplication context = BaseApplication.getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public static boolean d(QQAppInterface qQAppInterface, List<MessageForFile> list, List<MessageForDLFile> list2, ArrayList<MessageForPic> arrayList, ArrayList<MessageForShortVideo> arrayList2, ArrayList<StructMsgForImageShare> arrayList3, MqqHandler mqqHandler, int i3) {
        ArrayList arrayList4 = new ArrayList();
        long j3 = 0;
        for (MessageForFile messageForFile : list) {
            FileManagerEntity fileManagerEntityByMsgFile = FileManagerUtil.getFileManagerEntityByMsgFile(qQAppInterface, messageForFile);
            if (fileManagerEntityByMsgFile.cloudType != 0 && fileManagerEntityByMsgFile.status != 16) {
                arrayList4.add(messageForFile);
                j3 += fileManagerEntityByMsgFile.fileSize;
            }
        }
        for (MessageForDLFile messageForDLFile : list2) {
            int i16 = messageForDLFile.deviceType;
            DataLineMsgRecord d16 = qQAppInterface.getMessageFacade().t1(i16).d(messageForDLFile.associatedId);
            if (d16 != null && FileUtils.fileExistsAndNotEmpty(d16.path)) {
                j3 += d16.filesize;
                arrayList4.add(messageForDLFile);
            }
        }
        if (list.size() + list2.size() > 0 && arrayList4.size() == 0) {
            d.e(R.string.b_r);
            return false;
        }
        if (FileManagerUtil.is2GOr3G() && j3 > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            FMDialogUtil.a(BaseActivity.sTopActivity, R.string.b_v, R.string.f170958ba0, new b(qQAppInterface, list, list2, arrayList, arrayList2, arrayList3, mqqHandler, i3));
            return false;
        }
        return l(qQAppInterface, list, list2, arrayList, arrayList2, arrayList3, mqqHandler, i3);
    }

    private static void e(QQAppInterface qQAppInterface, Activity activity, DataLineMsgRecord dataLineMsgRecord) {
        if (FileManagerUtil.is2GOr3G() && dataLineMsgRecord.filesize > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            FMDialogUtil.a(activity, R.string.b_v, R.string.b_y, new c(qQAppInterface, activity, dataLineMsgRecord));
        } else {
            m(qQAppInterface, activity, dataLineMsgRecord);
        }
    }

    private static boolean f(ChatMessage chatMessage) {
        if (!ax.a(chatMessage) && !((IPicFlash) QRoute.api(IPicFlash.class)).isFlashPicMsg(chatMessage)) {
            return false;
        }
        return true;
    }

    public static boolean g(QQAppInterface qQAppInterface, Activity activity, int i3, List<ChatMessage> list, MqqHandler mqqHandler) {
        boolean z16;
        boolean d16;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ChatMessage chatMessage = list.get(0);
        ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).setRequestData(chatMessage.frienduin, chatMessage.senderuin, chatMessage.istroop);
        for (int i16 = 0; i16 < list.size(); i16++) {
            ChatMessage chatMessage2 = list.get(i16);
            if (chatMessage2 instanceof MessageForTroopFile) {
                arrayList.add(chatMessage2);
            } else if (chatMessage2 instanceof MessageForFile) {
                arrayList2.add((MessageForFile) chatMessage2);
            } else if (chatMessage2 instanceof MessageForDLFile) {
                arrayList3.add((MessageForDLFile) chatMessage2);
            } else if (chatMessage2 instanceof MessageForPic) {
                arrayList4.add((MessageForPic) chatMessage2);
            } else if (chatMessage2 instanceof MessageForShortVideo) {
                arrayList5.add((MessageForShortVideo) chatMessage2);
            } else if (MultiMsgProxy.r(chatMessage2)) {
                arrayList6.add((StructMsgForImageShare) ((MessageForStructing) chatMessage2).structingMsg);
            }
        }
        if (arrayList.size() > 0) {
            z16 = p(qQAppInterface, arrayList, activity);
        } else {
            z16 = false;
        }
        if (arrayList2.size() <= 0 && arrayList3.size() <= 0) {
            d16 = j(qQAppInterface, arrayList4, arrayList5, arrayList6, mqqHandler, i3);
        } else {
            d16 = d(qQAppInterface, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, mqqHandler, i3);
        }
        if (!d16 && !z16) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            QQToast.makeText(qQAppInterface.getApp(), R.string.f170978be3, 0).show(i3);
            return true;
        }
        QQToast.makeText(qQAppInterface.getApp(), R.string.bfg, 0).show(i3);
        return false;
    }

    public static boolean h(QQAppInterface qQAppInterface, int i3, List<AIOMsgItem> list) {
        boolean z16;
        boolean k3;
        boolean z17 = false;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            AIOMsgItem aIOMsgItem = list.get(0);
            String valueOf = String.valueOf(aIOMsgItem.getMsgRecord().getPeerUin());
            ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).setRequestData(valueOf, String.valueOf(aIOMsgItem.getMsgRecord().getSenderUin()), com.tencent.nt.adapter.session.c.c(aIOMsgItem.getMsgRecord().chatType));
            for (int i16 = 0; i16 < list.size(); i16++) {
                AIOMsgItem aIOMsgItem2 = list.get(i16);
                if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem2)) {
                    arrayList3.add(aIOMsgItem2);
                } else if (aIOMsgItem2.getMsgRecord().getMsgType() == 7) {
                    arrayList4.add(aIOMsgItem2);
                } else if (com.tencent.mobileqq.aio.utils.d.x(aIOMsgItem2)) {
                    if (aIOMsgItem2.getMsgRecord().getChatType() != 2) {
                        arrayList2.add(aIOMsgItem2);
                    } else {
                        arrayList.add(aIOMsgItem2);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                z16 = q(qQAppInterface, arrayList, valueOf);
            } else {
                z16 = false;
            }
            if (!arrayList2.isEmpty()) {
                k3 = cooperation.weiyun.a.d(qQAppInterface, arrayList2, arrayList3, arrayList4);
            } else {
                k3 = k(qQAppInterface, arrayList3, arrayList4);
            }
            if (k3 || z16) {
                z17 = true;
            }
            r(qQAppInterface, i3, z17);
        }
        return z17;
    }

    public static boolean i(QQAppInterface qQAppInterface, Activity activity, int i3, List<AIOMsgItem> list, int i16) {
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X80067F8", "0X80067F8", 0, 0, "", "", "", "");
        if (!NetworkUtil.isNetSupport(activity)) {
            QQToast.makeText(qQAppInterface.getApp(), R.string.b3j, 0).show(i3);
            return false;
        }
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                return t(qQAppInterface, activity, i3, list, i16);
            }
            return h(qQAppInterface, i3, list);
        }
        QQToast.makeText(qQAppInterface.getApp(), R.string.ced, 0).show(i3);
        return false;
    }

    static boolean j(QQAppInterface qQAppInterface, ArrayList<MessageForPic> arrayList, ArrayList<MessageForShortVideo> arrayList2, ArrayList<StructMsgForImageShare> arrayList3, MqqHandler mqqHandler, int i3) {
        if ((arrayList == null || arrayList.size() <= 0) && ((arrayList2 == null || arrayList2.size() <= 0) && (arrayList3 == null || arrayList3.size() <= 0))) {
            return false;
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3 != null && arrayList3.size() > 0) {
            Iterator<StructMsgForImageShare> it = arrayList3.iterator();
            while (it.hasNext()) {
                for (AbsStructMsgElement absStructMsgElement : it.next().mStructMsgItemLists) {
                    if (com.tencent.mobileqq.structmsg.a.class.isInstance(absStructMsgElement)) {
                        Iterator<AbsStructMsgElement> it5 = ((com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0.iterator();
                        while (it5.hasNext()) {
                            AbsStructMsgElement next = it5.next();
                            if (e.class.isInstance(next)) {
                                e eVar = (e) next;
                                if (!f(eVar.f290638c1) && !ZhituManager.h0(eVar.f290638c1)) {
                                    arrayList4.add(eVar.f290638c1);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<MessageForPic> it6 = arrayList.iterator();
            while (it6.hasNext()) {
                MessageForPic next2 = it6.next();
                if (!f(next2) && !ZhituManager.h0(next2)) {
                    arrayList4.add(next2);
                }
            }
        }
        if (arrayList4.size() == 0 && (arrayList2 == null || arrayList2.size() == 0)) {
            return false;
        }
        qQAppInterface.getFileManagerEngine().Y().C(arrayList4, arrayList2, new WeiyunCallbackImpl(mqqHandler, qQAppInterface.getApp(), qQAppInterface));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(QQAppInterface qQAppInterface, ArrayList<AIOMsgItem> arrayList, ArrayList<AIOMsgItem> arrayList2) {
        if ((arrayList == null || arrayList.size() <= 0) && (arrayList2 == null || arrayList2.size() <= 0)) {
            return false;
        }
        ArrayList arrayList3 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<AIOMsgItem> it = arrayList.iterator();
            while (it.hasNext()) {
                AIOMsgItem next = it.next();
                MsgElement firstTypeElement = next.getFirstTypeElement(2);
                if (firstTypeElement != null && firstTypeElement.getPicElement() != null && !com.tencent.mobileqq.richmediabrowser.utils.c.w(firstTypeElement.getPicElement()) && !com.tencent.mobileqq.aio.utils.d.y(next)) {
                    arrayList3.add(next);
                }
            }
        }
        if (arrayList3.size() == 0 && (arrayList2 == null || arrayList2.size() == 0)) {
            return false;
        }
        if (arrayList2 != null) {
            arrayList3.addAll(arrayList2);
        }
        qQAppInterface.getFileManagerEngine().Y().E(arrayList3, new WeiyunCallbackImpl(null, qQAppInterface.getApp(), qQAppInterface));
        return true;
    }

    public static boolean l(QQAppInterface qQAppInterface, List<MessageForFile> list, List<MessageForDLFile> list2, ArrayList<MessageForPic> arrayList, ArrayList<MessageForShortVideo> arrayList2, ArrayList<StructMsgForImageShare> arrayList3, MqqHandler mqqHandler, int i3) {
        FileManagerEntity fileManagerEntity;
        Iterator<MessageForFile> it = list.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= FileManagerUtil.initSaveToWeiYun(qQAppInterface, it.next(), BaseActivity.sTopActivity, true);
        }
        for (MessageForDLFile messageForDLFile : list2) {
            int i16 = messageForDLFile.deviceType;
            DataLineMsgRecord d16 = qQAppInterface.getMessageFacade().t1(i16).d(messageForDLFile.associatedId);
            if (d16 != null) {
                boolean fileExistsAndNotEmpty = FileUtils.fileExistsAndNotEmpty(d16.path);
                if (fileExistsAndNotEmpty) {
                    if (d16.nWeiyunSessionId != 0) {
                        fileManagerEntity = qQAppInterface.getFileManagerDataCenter().D(d16.nWeiyunSessionId);
                    } else {
                        fileManagerEntity = null;
                    }
                    if (fileManagerEntity == null) {
                        d16.nWeiyunSessionId = qQAppInterface.getFileManagerEngine().F0(d16.path, null, qQAppInterface.getAccount(), "", 0, false).nSessionId;
                        qQAppInterface.getMessageFacade().t1(i16).j(d16.msgId);
                    } else {
                        qQAppInterface.getFileManagerEngine().o0(d16.nWeiyunSessionId);
                    }
                }
                z16 |= fileExistsAndNotEmpty;
            }
        }
        boolean j3 = j(qQAppInterface, arrayList, arrayList2, arrayList3, mqqHandler, i3);
        if (!z16 && !j3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(QQAppInterface qQAppInterface, Activity activity, DataLineMsgRecord dataLineMsgRecord) {
        FileManagerEntity fileManagerEntity;
        if (dataLineMsgRecord.nWeiyunSessionId != 0) {
            fileManagerEntity = qQAppInterface.getFileManagerDataCenter().D(dataLineMsgRecord.nWeiyunSessionId);
        } else {
            fileManagerEntity = null;
        }
        int devTypeBySeId = DataLineMsgRecord.getDevTypeBySeId(dataLineMsgRecord.sessionid);
        if (fileManagerEntity == null) {
            d.h(FileManagerUtil.cutLongName(dataLineMsgRecord.filename) + activity.getString(R.string.f170976be1));
            dataLineMsgRecord.nWeiyunSessionId = qQAppInterface.getFileManagerEngine().F0(dataLineMsgRecord.path, null, qQAppInterface.getAccount(), "", 0, false).nSessionId;
            qQAppInterface.getMessageFacade().t1(devTypeBySeId).j(dataLineMsgRecord.msgId);
            return;
        }
        d.h(FileManagerUtil.cutLongName(dataLineMsgRecord.filename) + activity.getString(R.string.f170976be1));
        qQAppInterface.getFileManagerEngine().o0(dataLineMsgRecord.nWeiyunSessionId);
    }

    private static boolean n(QQAppInterface qQAppInterface, Context context, AIOMsgItem aIOMsgItem) {
        MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
        if (((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).getFileMsgElem(msgRecord) == null) {
            return false;
        }
        int chatType = msgRecord.getChatType();
        if (chatType != 1) {
            if (chatType != 2) {
                if (chatType != 8) {
                    return false;
                }
                cooperation.weiyun.a.e(qQAppInterface, aIOMsgItem, DataLineNTMsgMigrationUtil.d(msgRecord.peerUid), DataLineNTMsgMigrationUtil.i(msgRecord.peerUid));
            } else {
                TroopFileUtils.C(context, qQAppInterface, aIOMsgItem);
            }
        } else {
            cooperation.weiyun.a.e(qQAppInterface, aIOMsgItem, String.valueOf(msgRecord.getPeerUin()), msgRecord.getChatType());
        }
        return true;
    }

    private static void o(final QQAppInterface qQAppInterface, Context context, final int i3, AIOMsgItem aIOMsgItem, int i16) {
        if (qQAppInterface == null) {
            return;
        }
        qQAppInterface.getFileManagerEngine().Y().D(aIOMsgItem, i16, new WeiyunCallbackImpl(null, context, qQAppInterface));
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.weiyun.WeiyunAIOUtils.3
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(QQAppInterface.this.getApp(), R.string.f170978be3, 0).show(i3);
                }
            });
        } else {
            QQToast.makeText(qQAppInterface.getApp(), R.string.f170978be3, 0).show(i3);
        }
    }

    private static boolean p(QQAppInterface qQAppInterface, ArrayList<ChatMessage> arrayList, Activity activity) {
        t m3;
        ChatMessage chatMessage = arrayList.get(0);
        if (TroopFileTransferManager.O(qQAppInterface, Long.parseLong(chatMessage.frienduin)) == null || (m3 = TroopFileUtils.m(qQAppInterface, (MessageForTroopFile) chatMessage)) == null || m3.f294985s == null) {
            return false;
        }
        TroopFileUtils.z(activity, qQAppInterface, arrayList);
        return true;
    }

    private static boolean q(QQAppInterface qQAppInterface, ArrayList<AIOMsgItem> arrayList, String str) {
        if (TroopFileTransferManager.O(qQAppInterface, Long.parseLong(str)) == null) {
            return false;
        }
        TroopFileUtils.B(qQAppInterface, Long.valueOf(str).longValue(), arrayList);
        return true;
    }

    private static void r(QQAppInterface qQAppInterface, int i3, boolean z16) {
        if (z16) {
            QQToast.makeText(qQAppInterface.getApp(), R.string.f170978be3, 0).show(i3);
        } else {
            QQToast.makeText(qQAppInterface.getApp(), R.string.bfg, 0).show(i3);
        }
    }

    public static boolean s(final QQAppInterface qQAppInterface, Activity activity, final int i3, List<ChatMessage> list, MqqHandler mqqHandler) {
        ChatMessage chatMessage = list.get(0);
        ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).setRequestData(chatMessage.frienduin, chatMessage.senderuin, chatMessage.istroop);
        if (chatMessage instanceof MessageForTroopFile) {
            TroopFileUtils.D(activity, qQAppInterface, chatMessage);
            return true;
        }
        if (chatMessage instanceof MessageForFile) {
            MessageForFile messageForFile = (MessageForFile) chatMessage;
            FileManagerEntity fileManagerEntityByMsgFile = FileManagerUtil.getFileManagerEntityByMsgFile(qQAppInterface, messageForFile);
            if (fileManagerEntityByMsgFile.cloudType == 0) {
                d.e(R.string.b_r);
                return false;
            }
            if (fileManagerEntityByMsgFile.status == 16) {
                d.e(R.string.bet);
                return false;
            }
            if (kc1.a.b(messageForFile).c(false)) {
                FMDialogUtil.a(BaseActivity.sTopActivity, R.string.b_v, R.string.b_y, new a(qQAppInterface, chatMessage));
                return true;
            }
            FileManagerUtil.initSaveToWeiYun(qQAppInterface, chatMessage, BaseActivity.sTopActivity);
            return true;
        }
        boolean z16 = chatMessage instanceof MessageForPic;
        if (!z16 && !(chatMessage instanceof MessageForShortVideo)) {
            if (chatMessage instanceof MessageForDLFile) {
                MessageForDLFile messageForDLFile = (MessageForDLFile) chatMessage;
                int i16 = messageForDLFile.deviceType;
                DataLineMsgRecord d16 = qQAppInterface.getMessageFacade().t1(i16).d(messageForDLFile.associatedId);
                if (d16 != null) {
                    if (!FileUtils.fileExistsAndNotEmpty(d16.path)) {
                        d.e(R.string.b_r);
                        return false;
                    }
                    e(qQAppInterface, activity, d16);
                    return true;
                }
                return true;
            }
            if (MultiMsgProxy.r(chatMessage)) {
                StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) ((MessageForStructing) chatMessage).structingMsg;
                ArrayList arrayList = new ArrayList();
                for (AbsStructMsgElement absStructMsgElement : structMsgForImageShare.mStructMsgItemLists) {
                    if (com.tencent.mobileqq.structmsg.a.class.isInstance(absStructMsgElement)) {
                        Iterator<AbsStructMsgElement> it = ((com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0.iterator();
                        while (it.hasNext()) {
                            AbsStructMsgElement next = it.next();
                            if (e.class.isInstance(next)) {
                                e eVar = (e) next;
                                if (!f(eVar.f290638c1)) {
                                    arrayList.add(eVar.f290638c1);
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    j(qQAppInterface, arrayList, null, null, mqqHandler, i3);
                    QQToast.makeText(qQAppInterface.getApp(), R.string.f170978be3, 0).show(i3);
                    return true;
                }
                QQToast.makeText(qQAppInterface.getApp(), R.string.bfg, 0).show(i3);
                return true;
            }
            QQToast.makeText(qQAppInterface.getApp(), R.string.bfg, 0).show(i3);
            return false;
        }
        if (f(chatMessage)) {
            d.e(R.string.b_r);
            return false;
        }
        if (z16 && ZhituManager.h0((MessageForPic) chatMessage)) {
            d.e(R.string.b_r);
            return false;
        }
        qQAppInterface.getFileManagerEngine().Y().A(chatMessage, new WeiyunCallbackImpl(mqqHandler, activity, qQAppInterface));
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.weiyun.WeiyunAIOUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(QQAppInterface.this.getApp(), R.string.f170978be3, 0).show(i3);
                }
            });
            return true;
        }
        QQToast.makeText(qQAppInterface.getApp(), R.string.f170978be3, 0).show(i3);
        return true;
    }

    public static boolean t(QQAppInterface qQAppInterface, Context context, int i3, List<AIOMsgItem> list, int i16) {
        if (list.isEmpty()) {
            return false;
        }
        AIOMsgItem aIOMsgItem = list.get(0);
        MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
        ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).setRequestData(String.valueOf(msgRecord.getPeerUin()), String.valueOf(msgRecord.getSenderUin()), com.tencent.nt.adapter.session.c.c(msgRecord.chatType));
        if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem)) {
            if (!com.tencent.mobileqq.aio.utils.d.y(aIOMsgItem) && !com.tencent.mobileqq.richmediabrowser.utils.c.w(aIOMsgItem.getFirstTypeElement(2).getPicElement())) {
                o(qQAppInterface, context, i3, aIOMsgItem, 0);
                return true;
            }
            d.e(R.string.b_r);
            return false;
        }
        if (aIOMsgItem.getMsgRecord().getMsgType() == 7) {
            o(qQAppInterface, context, i3, aIOMsgItem, 0);
            return true;
        }
        if (com.tencent.mobileqq.aio.utils.d.x(aIOMsgItem)) {
            if (!n(qQAppInterface, context, aIOMsgItem)) {
                return false;
            }
            return true;
        }
        if (com.tencent.mobileqq.aio.utils.d.E(aIOMsgItem)) {
            o(qQAppInterface, context, i3, aIOMsgItem, i16);
            return true;
        }
        return true;
    }

    public static void u(Activity activity) {
        String format = String.format("https://jump.weiyun.com?from=3092&aid=%s", "qq_an_wyshouxian");
        Intent intent = new Intent();
        intent.setClass(activity, QQBrowserActivity.class);
        intent.putExtra("url", format);
        activity.startActivityForResult(intent, 21);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f391490a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChatMessage f391491b;

        a(QQAppInterface qQAppInterface, ChatMessage chatMessage) {
            this.f391490a = qQAppInterface;
            this.f391491b = chatMessage;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            FileManagerUtil.initSaveToWeiYun(this.f391490a, this.f391491b, BaseActivity.sTopActivity);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f391492a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f391493b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f391494c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f391495d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f391496e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f391497f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ MqqHandler f391498g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f391499h;

        b(QQAppInterface qQAppInterface, List list, List list2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, MqqHandler mqqHandler, int i3) {
            this.f391492a = qQAppInterface;
            this.f391493b = list;
            this.f391494c = list2;
            this.f391495d = arrayList;
            this.f391496e = arrayList2;
            this.f391497f = arrayList3;
            this.f391498g = mqqHandler;
            this.f391499h = i3;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            if (WeiyunAIOUtils.l(this.f391492a, this.f391493b, this.f391494c, this.f391495d, this.f391496e, this.f391497f, this.f391498g, this.f391499h)) {
                QQToast.makeText(this.f391492a.getApp(), R.string.f170978be3, 0).show(this.f391499h);
            } else {
                QQToast.makeText(this.f391492a.getApp(), R.string.bfg, 0).show(this.f391499h);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f391500a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f391501b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ DataLineMsgRecord f391502c;

        c(QQAppInterface qQAppInterface, Activity activity, DataLineMsgRecord dataLineMsgRecord) {
            this.f391500a = qQAppInterface;
            this.f391501b = activity;
            this.f391502c = dataLineMsgRecord;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            WeiyunAIOUtils.m(this.f391500a, this.f391501b, this.f391502c);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}
