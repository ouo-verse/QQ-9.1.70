package com.tencent.qqnt.aio.adapter.richmedia.provider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.nt.NTFileManageBridger;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.richmedia.provider.h;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J(\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J \u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J4\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J*\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J,\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J \u0010#\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020!H\u0016J(\u0010)\u001a\u00020!2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000eH\u0016R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b,\u0010-R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/richmedia/provider/AIOFileProvider;", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElem", "Lcom/tencent/mobileqq/filemanager/data/ForwardFileInfo;", "k", "", "localPath", "", "r", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "subId", "", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "c", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "type", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "cb", "g", "a", "curType", "Landroid/content/Intent;", tl.h.F, "", "isCompleted", "f", "Lcom/tencent/mobileqq/data/ChatMessage;", "msg", "Lcom/tencent/mobileqq/app/QBaseActivity;", "topActivity", "appRuntime", "d", "Lcom/tencent/mobileqq/filemanager/nt/NTFileManageBridger;", "Lkotlin/Lazy;", "o", "()Lcom/tencent/mobileqq/filemanager/nt/NTFileManageBridger;", "fileManagerBridger", "b", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOFileProvider implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy fileManagerBridger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String localPath;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(((MsgElement) t16).fileElement.fileGroupIndex, ((MsgElement) t17).fileElement.fileGroupIndex);
            return compareValues;
        }
    }

    public AIOFileProvider() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NTFileManageBridger>() { // from class: com.tencent.qqnt.aio.adapter.richmedia.provider.AIOFileProvider$fileManagerBridger$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NTFileManageBridger invoke() {
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
                Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                return new NTFileManageBridger((QQAppInterface) waitAppRuntime);
            }
        });
        this.fileManagerBridger = lazy;
    }

    private final ForwardFileInfo k(MsgRecord msgRecord, FileElement fileElem) {
        Object first;
        long p16 = p(msgRecord);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ForwardFileInfo e16 = NTFileUtils.e((QQAppInterface) waitAppRuntime, msgRecord, p16);
        if (e16 != null) {
            return e16;
        }
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.N(10000);
        forwardFileInfo.V(msgRecord.msgId);
        forwardFileInfo.y(fileElem.fileName);
        forwardFileInfo.z(fileElem.fileSize);
        forwardFileInfo.C(fileElem.filePath);
        HashMap<Integer, String> hashMap = fileElem.picThumbPath;
        if (hashMap != null && hashMap.size() > 0) {
            Collection<String> values = fileElem.picThumbPath.values();
            Intrinsics.checkNotNullExpressionValue(values, "fileElem.picThumbPath.values");
            first = CollectionsKt___CollectionsKt.first(values);
            forwardFileInfo.G((String) first);
        }
        return forwardFileInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(int i3, String str) {
        QLog.i("AIOFileProvider", 1, "download errCode: " + i3 + ", errMsg: " + str);
    }

    private final NTFileManageBridger o() {
        return (NTFileManageBridger) this.fileManagerBridger.getValue();
    }

    private final long p(MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList == null) {
            return 0L;
        }
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.fileElement != null) {
                return next.elementId;
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int i3) {
        QLog.i("AIOFileProvider", 1, " save troop file to weiyun, result:" + i3);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void a(MsgRecord msgRecord, int subId, int type, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (!(msgElement == null && (msgElement = qu3.i.e(msgRecord)) == null) && ah.o0(msgElement.fileElement.fileName) == 0) {
            o().I(null, msgRecord, msgElement.elementId);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void b(MsgRecord msgRecord, int i3, int i16, MsgElement msgElement, int i17, int i18, VideoCodecFormatType videoCodecFormatType, i iVar) {
        h.a.c(this, msgRecord, i3, i16, msgElement, i17, i18, videoCodecFormatType, iVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<AIORichMediaData> c(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement, int subId) {
        List listOf;
        Iterator it;
        int intValue;
        int intValue2;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList arrayList = new ArrayList();
        Integer num = msgRecord.fileGroupSize;
        if (num != null) {
            Intrinsics.checkNotNullExpressionValue(num, "msgRecord.fileGroupSize");
            if (num.intValue() > 1) {
                ArrayList<MsgElement> arrayList2 = msgRecord.elements;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.elements");
                listOf = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new b());
                it = listOf.iterator();
                while (it.hasNext()) {
                    FileElement fileElem = ((MsgElement) it.next()).fileElement;
                    Intrinsics.checkNotNullExpressionValue(fileElem, "fileElem");
                    int d16 = com.tencent.qqnt.aio.element.file.util.a.d(fileElem);
                    if (d16 == 0) {
                        Integer num2 = fileElem.fileGroupIndex;
                        if (num2 == null) {
                            intValue2 = subId;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(num2, "fileElem.fileGroupIndex ?: subId");
                            intValue2 = num2.intValue();
                        }
                        AIORichMediaData l3 = l(app, msgRecord, fileElem, intValue2);
                        if (l3 != null) {
                            arrayList.add(l3);
                        }
                    } else if (d16 == 2) {
                        Integer num3 = fileElem.fileGroupIndex;
                        if (num3 == null) {
                            intValue = subId;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(num3, "fileElem.fileGroupIndex ?: subId");
                            intValue = num3.intValue();
                        }
                        AIORichMediaData m3 = m(msgRecord, fileElem, intValue);
                        if (m3 != null) {
                            arrayList.add(m3);
                        }
                    }
                }
                return arrayList;
            }
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(qu3.i.e(msgRecord));
        it = listOf.iterator();
        while (it.hasNext()) {
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean d(ChatMessage msg2, MsgRecord msgRecord, QBaseActivity topActivity, AppRuntime appRuntime) {
        String str;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(topActivity, "topActivity");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        MsgElement e16 = qu3.i.e(msgRecord);
        if (e16 == null) {
            return true;
        }
        int i3 = msgRecord.chatType;
        if (i3 == 1) {
            FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(e16.elementId, msg2.frienduin, msg2.istroop);
            if (E == null) {
                return true;
            }
            int cloudType = E.getCloudType();
            if (cloudType == 1) {
                if (MsgExtKt.S(msgRecord)) {
                    str = qQAppInterface.getCurrentAccountUin();
                } else {
                    str = E.peerUin;
                }
                qQAppInterface.getFileManagerEngine().v0(E, str);
            } else if (cloudType != 3 && cloudType != 5) {
                QLog.i("AIOFileProvider", 1, "other cloud type: " + E.getCloudType());
            } else {
                qQAppInterface.getFileManagerEngine().F0(E.getFilePath(), null, qQAppInterface.getAccount(), "", 0, false);
            }
        } else if (i3 == 2) {
            com.tencent.mobileqq.filemanager.util.d.d(topActivity.getString(R.string.f170978be3));
            String str2 = msg2.frienduin;
            Intrinsics.checkNotNullExpressionValue(str2, "msg.frienduin");
            TroopFileTransferManager O = TroopFileTransferManager.O(qQAppInterface, Long.parseLong(str2));
            if (O == null) {
                QLog.i("AIOFileProvider", 1, "TroopFileTransferManager is null");
            }
            FileElement fileElement = e16.fileElement;
            if (fileElement != null) {
                String str3 = fileElement.filePath;
                String str4 = fileElement.fileName;
                long j3 = fileElement.fileSize;
                Integer num = fileElement.fileBizId;
                Intrinsics.checkNotNullExpressionValue(num, "it.fileBizId");
                O.w0(str3, str4, j3, num.intValue(), new TroopFileTransferManager.c() { // from class: com.tencent.qqnt.aio.adapter.richmedia.provider.b
                    @Override // com.tencent.mobileqq.troop.utils.TroopFileTransferManager.c
                    public final void onResult(int i16) {
                        AIOFileProvider.q(i16);
                    }
                });
            }
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public boolean e(int i3, int i16) {
        return h.a.a(this, i3, i16);
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public int f(MsgRecord msgRecord, int type, boolean isCompleted) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MsgElement e16 = qu3.i.e(msgRecord);
        FileElement fileElement = e16 != null ? e16.fileElement : null;
        return ah.o0(fileElement != null ? fileElement.fileName : null) == 2 ? isCompleted ? 269484034 : 269484035 : type;
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public void g(MsgRecord msgRecord, int subId, int type, MsgElement msgElement, i cb5) {
        MsgElement msgElement2;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null) {
            msgElement2 = qu3.i.e(msgRecord);
            if (msgElement2 == null) {
                return;
            }
        } else {
            msgElement2 = msgElement;
        }
        if (type == 18) {
            o().Q(null, msgRecord, msgElement2.elementId, true, cb5);
        } else {
            o().O(null, null, msgRecord, msgElement2.elementId, "", new NTFileManageBridger.f() { // from class: com.tencent.qqnt.aio.adapter.richmedia.provider.a
                @Override // com.tencent.mobileqq.filemanager.nt.NTFileManageBridger.f
                public final void onResult(int i3, String str) {
                    AIOFileProvider.n(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.h
    public Intent h(MsgRecord msgRecord, int subId, MsgElement msgElement, int curType) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && (msgElement = qu3.i.e(msgRecord)) == null) {
            return null;
        }
        FileElement fileElem = msgElement.fileElement;
        Intent intent = new Intent();
        intent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putBoolean("not_forward", true);
        Intrinsics.checkNotNullExpressionValue(fileElem, "fileElem");
        bundle.putParcelable("fileinfo", k(msgRecord, fileElem));
        bundle.putString(AppConstants.Key.FORWARD_TEXT, HardCodeUtil.qqStr(R.string.f201304ug) + FileManagerUtil.cutLongName(fileElem.fileName) + HardCodeUtil.qqStr(R.string.f201314uh) + q.g(fileElem.fileSize) + "\u3002");
        bundle.putBoolean("direct_send_if_dataline_forward", true);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, fileElem.filePath);
        intent.putExtras(bundle);
        intent.putExtra("extra.MSG_ID", msgRecord.msgId);
        return intent;
    }

    public final AIORichMediaData l(AppRuntime app, MsgRecord msgRecord, FileElement fileElem, int subId) {
        Object first;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(fileElem, "fileElem");
        AIOFilePicData aIOFilePicData = new AIOFilePicData();
        ru3.c.f432503a.a(msgRecord, aIOFilePicData);
        aIOFilePicData.F = msgRecord.peerUid;
        aIOFilePicData.C = false;
        aIOFilePicData.U = app.getCurrentAccountUin();
        aIOFilePicData.G = su3.a.c(msgRecord);
        int i3 = msgRecord.sendType;
        if (i3 == 1 || i3 == 2) {
            aIOFilePicData.V = 1;
        }
        aIOFilePicData.f179631h = fileElem.fileSize;
        aIOFilePicData.Z = fileElem.fileMd5;
        Integer num = fileElem.picWidth;
        Intrinsics.checkNotNullExpressionValue(num, "fileElem.picWidth");
        aIOFilePicData.f179567a0 = num.intValue();
        Integer num2 = fileElem.picHeight;
        Intrinsics.checkNotNullExpressionValue(num2, "fileElem.picHeight");
        aIOFilePicData.f179568b0 = num2.intValue();
        Integer num3 = fileElem.invalidState;
        Intrinsics.checkNotNullExpressionValue(num3, "fileElem.invalidState");
        aIOFilePicData.f179569c0 = num3.intValue();
        HashMap<Integer, String> hashMap = fileElem.picThumbPath;
        if (hashMap != null && hashMap.size() > 0) {
            Collection<String> values = fileElem.picThumbPath.values();
            Intrinsics.checkNotNullExpressionValue(values, "fileElem.picThumbPath.values");
            first = CollectionsKt___CollectionsKt.first(values);
            aIOFilePicData.H = (String) first;
        }
        if (TextUtils.isEmpty(fileElem.filePath)) {
            aIOFilePicData.J = AIOBrowserBaseData.MEDIA_FILE_NONE;
            aIOFilePicData.I = AIOBrowserBaseData.MEDIA_FILE_NONE;
        } else {
            String str = fileElem.filePath;
            aIOFilePicData.I = str;
            aIOFilePicData.J = str;
        }
        aIOFilePicData.W = fileElem.fileName;
        Integer num4 = fileElem.invalidState;
        aIOFilePicData.Q = num4 == null || num4.intValue() != 0;
        aIOFilePicData.R = fileElem.fileSize;
        aIOFilePicData.f179629e = subId;
        return aIOFilePicData;
    }

    public final AIORichMediaData m(MsgRecord msgRecord, FileElement fileElem, int subId) {
        String str;
        Object first;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(fileElem, "fileElem");
        Integer num = fileElem.invalidState;
        if (num == null || num.intValue() != 0) {
            QLog.i("AIOFileProvider", 1, "createVideoMediaData. id: " + msgRecord.msgId + " file is invalid!");
            return null;
        }
        AIOFileVideoData aIOFileVideoData = new AIOFileVideoData();
        aIOFileVideoData.U = msgRecord.peerUid;
        aIOFileVideoData.f179628d = msgRecord.msgId;
        aIOFileVideoData.f179630f = msgRecord.msgTime;
        aIOFileVideoData.f179632i = msgRecord.msgSeq;
        aIOFileVideoData.V = su3.a.c(msgRecord);
        aIOFileVideoData.f179633m = su3.a.c(msgRecord);
        aIOFileVideoData.C = false;
        int i3 = msgRecord.sendType;
        if (i3 == 1 || i3 == 2) {
            aIOFileVideoData.W = 1;
        }
        HashMap<Integer, String> hashMap = fileElem.picThumbPath;
        if (hashMap != null && hashMap.size() > 0) {
            Collection<String> values = fileElem.picThumbPath.values();
            Intrinsics.checkNotNullExpressionValue(values, "fileElem.picThumbPath.values");
            first = CollectionsKt___CollectionsKt.first(values);
            aIOFileVideoData.G = (String) first;
        }
        aIOFileVideoData.Y = fileElem.fileMd5;
        aIOFileVideoData.f179631h = fileElem.fileSize;
        aIOFileVideoData.F = fileElem.fileName;
        Integer num2 = fileElem.picHeight;
        Intrinsics.checkNotNullExpressionValue(num2, "fileElem.picHeight");
        aIOFileVideoData.K = num2.intValue();
        Integer num3 = fileElem.picWidth;
        Intrinsics.checkNotNullExpressionValue(num3, "fileElem.picWidth");
        aIOFileVideoData.J = num3.intValue();
        if (!TextUtils.isEmpty(fileElem.filePath)) {
            str = fileElem.filePath;
        } else {
            str = this.localPath;
        }
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            aIOFileVideoData.H = str;
            aIOFileVideoData.P = true;
        }
        aIOFileVideoData.f179629e = subId;
        return aIOFileVideoData;
    }

    public final void r(String localPath) {
        this.localPath = localPath;
    }
}
