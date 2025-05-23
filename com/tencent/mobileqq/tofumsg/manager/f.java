package com.tencent.mobileqq.tofumsg.manager;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tofumsg.NewTofuManager;
import com.tencent.mobileqq.tofumsg.TofuLimitMsg;
import com.tencent.mobileqq.tofumsg.manager.factory.TofuManagerFactory;
import com.tencent.mobileqq.tofumsg.o;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TofuContent;
import com.tencent.qqnt.kernel.nativeinterface.TofuRecordElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bW\u0010XJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J8\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\r`\u000e2\u001a\u0010\u000f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\r`\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00180\fj\b\u0012\u0004\u0012\u00020\u0018`\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J(\u0010&\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016J!\u0010-\u001a\u00020\n\"\b\b\u0000\u0010,*\u00020)2\u0006\u0010*\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b-\u0010.J&\u0010/\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u00100\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020)0\u00042\u0006\u0010\u0003\u001a\u00020\u0002J$\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010,*\u00020)2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J'\u00105\u001a\u00020\n\"\b\b\u0000\u0010,*\u00020)2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010*\u001a\u00028\u0000\u00a2\u0006\u0004\b5\u00106J\u001e\u00109\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00108\u001a\u000207J\u0016\u0010<\u001a\u00020\n2\u0006\u0010;\u001a\u00020:2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010=\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)J\u000e\u0010>\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)J\u000e\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020)R\"\u0010G\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010M\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010P\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010B\u001a\u0004\bN\u0010D\"\u0004\bO\u0010FR&\u0010S\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00040Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010RR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010U\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/tofumsg/manager/f;", "Lsr2/a;", "", "friendUin", "Ljava/util/concurrent/CopyOnWriteArrayList;", "deleteTofuUUIDList", "", "deleteAllNtTofu", "Lcom/tencent/mobileqq/tofumsg/manager/factory/b;", "iDeleteNtDbTofuCallback", "", "v", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", "tofuMsgItemList", "y", "Lcom/tencent/mobileqq/data/NewBeancurdMsg;", "newBeancurdMsg", UserInfo.SEX_FEMALE, "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuContent;", "J", "", "K", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aio/data/AIOParam;", "aioParam", "aioCreate", "aioDestroy", "e", "f", "Lmqq/app/AppRuntime;", "appRuntime", "", "result", "errMsg", "I", "i", "b", "Lcom/tencent/mobileqq/tofumsg/TofuLimitMsg;", "tofuLimitMsg", tl.h.F, "T", "c", "(Lcom/tencent/mobileqq/tofumsg/TofuLimitMsg;)V", "d", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "tofuMsgList", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "E", "(Lcom/tencent/mobileqq/data/NewBeancurdMsg;Lcom/tencent/mobileqq/tofumsg/TofuLimitMsg;)V", "Lcom/tencent/mobileqq/aio/msg/ah$b;", "pendingExtraInfo", "L", "Lcom/tencent/common/app/AppInterface;", "appInterface", "p", ReportConstant.COSTREPORT_PREFIX, "t", "tarMsg", "r", "a", "Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "()Ljava/lang/String;", "setMLogTag", "(Ljava/lang/String;)V", "mLogTag", "Z", "getMInAIO", "()Z", "setMInAIO", "(Z)V", "mInAIO", "B", "setMCurFriendUin", "mCurFriendUin", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mLimitTofuCacheFromSelfTofuDB", "", "Ljava/lang/Object;", "mAddTofuLock", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class f implements sr2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mLogTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mInAIO;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCurFriendUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<TofuLimitMsg>> mLimitTofuCacheFromSelfTofuDB;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mAddTofuLock;

    /* JADX WARN: Incorrect field signature: TT; */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/tofumsg/manager/f$a", "Lcom/tencent/mobileqq/tofumsg/manager/factory/b;", "", "deleteSuc", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements com.tencent.mobileqq.tofumsg.manager.factory.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TofuLimitMsg f293294b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ NewBeancurdMsg f293295c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f293296d;

        /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mobileqq/tofumsg/manager/f;TT;Lcom/tencent/mobileqq/data/NewBeancurdMsg;Lmqq/app/AppRuntime;)V */
        a(TofuLimitMsg tofuLimitMsg, NewBeancurdMsg newBeancurdMsg, AppRuntime appRuntime) {
            this.f293294b = tofuLimitMsg;
            this.f293295c = newBeancurdMsg;
            this.f293296d = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, tofuLimitMsg, newBeancurdMsg, appRuntime);
            }
        }

        @Override // com.tencent.mobileqq.tofumsg.manager.factory.b
        public void onResult(boolean deleteSuc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, deleteSuc);
                return;
            }
            QLog.i(f.this.C(), 1, "insertTofuMsg:: deleteSuc=" + deleteSuc + " tofu=" + this.f293294b);
            if (deleteSuc) {
                if (f.this instanceof h) {
                    TofuManagerFactory tofuManagerFactory = TofuManagerFactory.f293297a;
                    sr2.a l3 = tofuManagerFactory.l("common");
                    sr2.a l16 = tofuManagerFactory.l("sogou");
                    if ((l3 instanceof CommonTofuManager) && (l16 instanceof i)) {
                        CommonTofuManager commonTofuManager = (CommonTofuManager) l3;
                        String str = this.f293295c.frienduin;
                        Intrinsics.checkNotNullExpressionValue(str, "newBeancurdMsg.frienduin");
                        CopyOnWriteArrayList z16 = commonTofuManager.z(commonTofuManager.D(str));
                        i iVar = (i) l16;
                        String str2 = this.f293295c.frienduin;
                        Intrinsics.checkNotNullExpressionValue(str2, "newBeancurdMsg.frienduin");
                        CopyOnWriteArrayList z17 = iVar.z(iVar.D(str2));
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        copyOnWriteArrayList.addAll(z16);
                        copyOnWriteArrayList.addAll(z17);
                        Iterator it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            TofuLimitMsg tofuLimitMsg = (TofuLimitMsg) it.next();
                            NewBeancurdMsg.ExtraTofuInfo parseToGetPushInfo = NewBeancurdMsg.ExtraTofuInfo.parseToGetPushInfo(this.f293295c.pushInfoString);
                            parseToGetPushInfo.isValid = false;
                            tofuLimitMsg.extra = parseToGetPushInfo.toJsonString();
                            o.b().c((QQAppInterface) this.f293296d, tofuLimitMsg);
                        }
                    } else {
                        QLog.i(f.this.C(), 1, "insertTofuMsg:: illegal tofuManager, forbid to insert tofu:" + this.f293294b);
                        return;
                    }
                }
                QLog.i(f.this.C(), 1, "insertTofuMsg:: real to insert to nt db:" + this.f293294b);
                f.this.F(this.f293295c);
                f.this.c(this.f293294b);
            }
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLogTag = "TOFU::";
        this.mCurFriendUin = "";
        this.mLimitTofuCacheFromSelfTofuDB = new ConcurrentHashMap<>();
        this.mAddTofuLock = new Object();
        this.mLogTag = this.mLogTag + A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(final NewBeancurdMsg newBeancurdMsg) {
        if (newBeancurdMsg != null && !TextUtils.isEmpty(newBeancurdMsg.frienduin)) {
            final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof QQAppInterface)) {
                QLog.i(this.mLogTag, 1, "insertTofuMsg2NtDb:: appRuntime is not QQAppInterface, return!!!" + newBeancurdMsg);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(newBeancurdMsg.extensionInfoStr);
                final long optLong = jSONObject.optLong("busiid");
                final String optString = jSONObject.optString("busi_uuid");
                int optInt = jSONObject.optInt("beancurd_style");
                JSONObject jSONObject2 = jSONObject.getJSONObject("description");
                TofuContent tofuContent = new TofuContent(jSONObject2.optString("detail"), jSONObject2.optString("color"));
                ArrayList<TofuContent> J = J(jSONObject);
                String optString2 = jSONObject.optString("background");
                String optString3 = jSONObject.optString("busiicon");
                String optString4 = jSONObject.optString("busi_extra");
                ArrayList<Long> K = K(jSONObject);
                if (com.tencent.qqnt.msg.f.j() != null) {
                    final String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(newBeancurdMsg.frienduin);
                    if (TextUtils.isEmpty(uidFromUin)) {
                        QLog.d(this.mLogTag, 1, "insertTofuMsg2NtDb:: convert uin failed, return!!!" + newBeancurdMsg);
                        return;
                    }
                    TofuRecordElement tofuRecordElement = new TofuRecordElement(optLong, optString, optInt, tofuContent, J, optString2, optString3, K, optString4);
                    QLog.d(this.mLogTag, 1, "insertTofuMsg2NtDb:: create tofuRecordElement\uff1a" + tofuRecordElement);
                    ((IMsgService) QRoute.api(IMsgService.class)).addLocalTofuRecordMsg(new Contact(1, uidFromUin, ""), tofuRecordElement, new IOperateCallback() { // from class: com.tencent.mobileqq.tofumsg.manager.d
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            f.G(f.this, uidFromUin, newBeancurdMsg, peekAppRuntime, optString, optLong, i3, str);
                        }
                    });
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.d(this.mLogTag, 1, "insertTofuMsg2NtDb:: doParse err: ", e16);
                return;
            }
        }
        QLog.i(this.mLogTag, 1, "insertTofuMsg2NtDb:: newBeancurdMsg is null | newBeancurdMsg.frienduin is empty, return!!!" + newBeancurdMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(final f this$0, String friendUid, NewBeancurdMsg newBeancurdMsg, AppRuntime appRuntime, final String str, final long j3, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.d(this$0.mLogTag, 1, "insertTofuMsg2NtDb:: insert tofu to NT msg db\uff0cresult:" + i3 + ", errMsg:" + errMsg + ", friendUid:" + friendUid + ", newBeancurdMsg:" + newBeancurdMsg);
        Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
        this$0.I(appRuntime, newBeancurdMsg, i3, errMsg);
        if (i3 == 0) {
            TofuManagerFactory tofuManagerFactory = TofuManagerFactory.f293297a;
            Intrinsics.checkNotNullExpressionValue(friendUid, "friendUid");
            tofuManagerFactory.i(1, friendUid, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.tofumsg.manager.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i16, String str2, ArrayList arrayList) {
                    f.H(str, j3, this$0, i16, str2, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(String str, long j3, f this$0, int i3, String str2, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MsgRecord msgRecord = (MsgRecord) it.next();
            if (msgRecord.msgType == 23) {
                Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
                ah ahVar = new ah(msgRecord);
                if (TextUtils.equals(str, ahVar.m2()) && j3 == ahVar.n2()) {
                    ah.a q26 = ahVar.q2();
                    q26.h(this$0.g());
                    ahVar.D2(q26, null);
                    return;
                }
            }
        }
    }

    private final ArrayList<TofuContent> J(JSONObject jsonObject) throws JSONException {
        if (!jsonObject.has("content_list")) {
            return null;
        }
        JSONArray jSONArray = jsonObject.getJSONArray("content_list");
        ArrayList<TofuContent> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            arrayList.add(new TofuContent(jSONObject.optString("detail"), jSONObject.optString("color")));
        }
        return arrayList;
    }

    private final ArrayList<Long> K(JSONObject jsonObject) throws JSONException, NumberFormatException {
        ArrayList<Long> arrayList = new ArrayList<>();
        JSONArray jSONArray = jsonObject.getJSONArray("frd_uin");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(Long.valueOf(jSONArray.getString(i3)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(NewBeancurdMsg newBeancurdMsg, ah.b pendingExtraInfo, int i3, String str, ArrayList arrayList) {
        int b16;
        boolean c16;
        int a16;
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "$newBeancurdMsg");
        Intrinsics.checkNotNullParameter(pendingExtraInfo, "$pendingExtraInfo");
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MsgRecord msgRecord = (MsgRecord) it.next();
            if (msgRecord.msgType == 23) {
                Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
                ah ahVar = new ah(msgRecord);
                if (TextUtils.equals(newBeancurdMsg.busiUuid, ahVar.m2()) && newBeancurdMsg.busiid == ahVar.n2()) {
                    ah.a q26 = ahVar.q2();
                    Integer b17 = pendingExtraInfo.b();
                    if (b17 != null) {
                        b16 = b17.intValue();
                    } else {
                        b16 = q26.b();
                    }
                    q26.h(b16);
                    Boolean c17 = pendingExtraInfo.c();
                    if (c17 != null) {
                        c16 = c17.booleanValue();
                    } else {
                        c16 = q26.c();
                    }
                    q26.i(c16);
                    Integer a17 = pendingExtraInfo.a();
                    if (a17 != null) {
                        a16 = a17.intValue();
                    } else {
                        a16 = q26.a();
                    }
                    q26.g(a16);
                    ahVar.D2(q26, null);
                    return;
                }
            }
        }
    }

    private final void v(String friendUin, final CopyOnWriteArrayList<String> deleteTofuUUIDList, final boolean deleteAllNtTofu, final com.tencent.mobileqq.tofumsg.manager.factory.b iDeleteNtDbTofuCallback) {
        if (!deleteAllNtTofu && deleteTofuUUIDList.size() <= 0) {
            QLog.i(this.mLogTag, 1, "deleteNtDbTofu:: deleteTofuUUIDList size is 0, delete complete");
            iDeleteNtDbTofuCallback.onResult(true);
            return;
        }
        final String friendUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(friendUin);
        if (TextUtils.isEmpty(friendUid)) {
            QLog.d(this.mLogTag, 1, "deleteNtDbTofu:: convert uin failed, return");
            iDeleteNtDbTofuCallback.onResult(false);
        } else {
            TofuManagerFactory tofuManagerFactory = TofuManagerFactory.f293297a;
            Intrinsics.checkNotNullExpressionValue(friendUid, "friendUid");
            tofuManagerFactory.i(1, friendUid, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.tofumsg.manager.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    f.w(f.this, deleteAllNtTofu, iDeleteNtDbTofuCallback, deleteTofuUUIDList, friendUid, i3, str, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final f this$0, boolean z16, final com.tencent.mobileqq.tofumsg.manager.factory.b iDeleteNtDbTofuCallback, CopyOnWriteArrayList deleteTofuUUIDList, String str, int i3, String str2, ArrayList msgList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(iDeleteNtDbTofuCallback, "$iDeleteNtDbTofuCallback");
        Intrinsics.checkNotNullParameter(deleteTofuUUIDList, "$deleteTofuUUIDList");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        ArrayList<MsgRecord> y16 = this$0.y(msgList);
        if (bl.b(y16)) {
            QLog.d(this$0.mLogTag, 1, "deleteNtDbTofu:: deleteAllNtTofu=" + z16 + ", illegal nt tofu msg list, invoke callback to notify");
            iDeleteNtDbTofuCallback.onResult(true);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        Iterator<MsgRecord> it = y16.iterator();
        while (it.hasNext()) {
            MsgRecord next = it.next();
            if (next != null && next.msgType == 23) {
                ah ahVar = new ah(next);
                if (z16) {
                    arrayList.add(Long.valueOf(ahVar.getMsgId()));
                    QLog.i(this$0.mLogTag, 1, "deleteNtDbTofu:: deleteAllNtTofu=" + z16 + ", -- add msg to needDeleteMsgList:" + ahVar);
                } else {
                    Iterator it5 = deleteTofuUUIDList.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            String str3 = (String) it5.next();
                            if (!TextUtils.isEmpty(str3) && TextUtils.equals(str3, ahVar.m2())) {
                                arrayList.add(Long.valueOf(ahVar.getMsgId()));
                                QLog.i(this$0.mLogTag, 1, "deleteNtDbTofu:: deleteAllNtTofu=" + z16 + ", -- add msg to needDeleteMsgList:" + ahVar);
                                break;
                            }
                        }
                    }
                }
            }
        }
        QLog.i(this$0.mLogTag, 1, "deleteNtDbTofu:: needDeleteMsgList size is: " + arrayList.size());
        if (arrayList.size() > 0) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteMsg(new Contact(1, str, ""), arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.tofumsg.manager.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str4) {
                    f.x(f.this, iDeleteNtDbTofuCallback, i16, str4);
                }
            });
        } else {
            QLog.i(this$0.mLogTag, 1, "deleteNtDbTofu:: needDeleteMsgList size <= 0; direct to invoke callback to notify");
            iDeleteNtDbTofuCallback.onResult(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(f this$0, com.tencent.mobileqq.tofumsg.manager.factory.b iDeleteNtDbTofuCallback, int i3, String delErrMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(iDeleteNtDbTofuCallback, "$iDeleteNtDbTofuCallback");
        Intrinsics.checkNotNullParameter(delErrMsg, "delErrMsg");
        boolean z16 = true;
        QLog.i(this$0.mLogTag, 1, "deleteNtDbTofu:: complete delete, result:" + i3 + ", errMsg:" + delErrMsg + " and invoke callback to notify");
        if (i3 != 0) {
            z16 = false;
        }
        iDeleteNtDbTofuCallback.onResult(z16);
    }

    private final ArrayList<MsgRecord> y(ArrayList<MsgRecord> tofuMsgItemList) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(this.mLogTag, 1, "filterTofuMsgItemInShowPeriod:: appRuntime is not QQAppInterface, return");
            return tofuMsgItemList;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        if (!(manager instanceof NewTofuManager)) {
            QLog.i(this.mLogTag, 1, "filterTofuMsgItemInShowPeriod:: manager is not NewTofuManager, return");
            return tofuMsgItemList;
        }
        ArrayList<MsgRecord> arrayList = new ArrayList<>();
        Iterator<MsgRecord> it = tofuMsgItemList.iterator();
        while (it.hasNext()) {
            MsgRecord next = it.next();
            if (next != null && ((NewTofuManager) manager).v(next.msgTime)) {
                QLog.i(this.mLogTag, 1, "filterTofuMsgItemInShowPeriod:: after filter, add msgRecord:" + next.msgId + ", msgTime:" + next.msgTime);
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NotNull
    public abstract String A();

    @NotNull
    public final String B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mCurFriendUin;
    }

    @NotNull
    public final String C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mLogTag;
    }

    @NotNull
    public final CopyOnWriteArrayList<TofuLimitMsg> D(@NotNull String friendUin) {
        CopyOnWriteArrayList<TofuLimitMsg> copyOnWriteArrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 21, (Object) this, (Object) friendUin);
        }
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(this.mLogTag, 1, "getTofuMsgFromTofuDB:: appRuntime is not QQAppInterface, return");
            return new CopyOnWriteArrayList<>();
        }
        synchronized (this.mAddTofuLock) {
            copyOnWriteArrayList = this.mLimitTofuCacheFromSelfTofuDB.get(friendUin);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = a((QQAppInterface) peekAppRuntime, friendUin);
                this.mLimitTofuCacheFromSelfTofuDB.put(friendUin, copyOnWriteArrayList);
            }
        }
        return copyOnWriteArrayList;
    }

    public final <T extends TofuLimitMsg> void E(@NotNull NewBeancurdMsg newBeancurdMsg, @NotNull T tofuLimitMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) newBeancurdMsg, (Object) tofuLimitMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        Intrinsics.checkNotNullParameter(tofuLimitMsg, "tofuLimitMsg");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(this.mLogTag, 1, "insertTofuMsg:: appRuntime is not QQAppInterface, return");
            return;
        }
        String str = newBeancurdMsg.frienduin;
        Intrinsics.checkNotNullExpressionValue(str, "newBeancurdMsg.frienduin");
        u(str, new a(tofuLimitMsg, newBeancurdMsg, peekAppRuntime));
    }

    public void I(@NotNull AppRuntime appRuntime, @NotNull NewBeancurdMsg newBeancurdMsg, int result, @NotNull String errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, appRuntime, newBeancurdMsg, Integer.valueOf(result), errMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i(this.mLogTag, 1, "insertTofuMsg2NtDbComplete:: appRuntime: " + appRuntime + ", newBeancurdMsg:" + newBeancurdMsg + ", result:" + result + ", errMsg:" + errMsg);
    }

    public final void L(@NotNull String friendUin, @NotNull final NewBeancurdMsg newBeancurdMsg, @NotNull final ah.b pendingExtraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, friendUin, newBeancurdMsg, pendingExtraInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        Intrinsics.checkNotNullParameter(pendingExtraInfo, "pendingExtraInfo");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(friendUin);
        if (uidFromUin != null && !TextUtils.isEmpty(uidFromUin)) {
            TofuManagerFactory.f293297a.i(1, uidFromUin, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.tofumsg.manager.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    f.M(NewBeancurdMsg.this, pendingExtraInfo, i3, str, arrayList);
                }
            });
        } else {
            QLog.d(this.mLogTag, 1, "updateNTTofuExtraInfo:: convert uin failed, return");
        }
    }

    @Override // sr2.a
    public void aioCreate(@NotNull AIOParam aioParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aioParam);
            return;
        }
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        this.mInAIO = true;
        String b16 = su3.c.b(aioParam);
        this.mCurFriendUin = b16;
        QLog.i(this.mLogTag, 1, "aioCreate:: uin = " + StringUtil.getSimpleUinForPrint(b16) + ", hashCode:" + hashCode());
    }

    @Override // sr2.a
    public void aioDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.i(this.mLogTag, 1, "aioDestroy:: uin = " + StringUtil.getSimpleUinForPrint(this.mCurFriendUin) + ", hashCode:" + hashCode());
        this.mInAIO = false;
        this.mCurFriendUin = "";
    }

    @Override // sr2.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        QLog.i(this.mLogTag, 1, "preLoadTofuMsg:: uin = " + StringUtil.getSimpleUinForPrint(this.mCurFriendUin) + ", hashCode:" + hashCode());
        if (TextUtils.isEmpty(this.mCurFriendUin)) {
            return;
        }
        D(this.mCurFriendUin);
    }

    @Override // sr2.a
    public <T extends TofuLimitMsg> void c(@NotNull T tofuLimitMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) tofuLimitMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(tofuLimitMsg, "tofuLimitMsg");
        QLog.i(this.mLogTag, 1, "insertTofuMsg2TofuDB:: insert start, tofuMsg=" + tofuLimitMsg);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(this.mLogTag, 1, "insertTofuMsg2TofuDB:: appRuntime is not QQAppInterface, return!!!" + tofuLimitMsg);
            return;
        }
        String str = tofuLimitMsg.friendUin;
        Intrinsics.checkNotNullExpressionValue(str, "tofuLimitMsg.friendUin");
        D(str).add(tofuLimitMsg);
        o.b().c((QQAppInterface) peekAppRuntime, tofuLimitMsg);
    }

    @Override // sr2.a
    public void d(@NotNull String friendUin, @NotNull CopyOnWriteArrayList<String> deleteTofuUUIDList, @NotNull com.tencent.mobileqq.tofumsg.manager.factory.b iDeleteNtDbTofuCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, friendUin, deleteTofuUUIDList, iDeleteNtDbTofuCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(deleteTofuUUIDList, "deleteTofuUUIDList");
        Intrinsics.checkNotNullParameter(iDeleteNtDbTofuCallback, "iDeleteNtDbTofuCallback");
        QLog.i(this.mLogTag, 1, "deleteSpecificNtDbTofuInSync:: uin: " + StringUtil.getSimpleUinForPrint(friendUin));
        v(friendUin, deleteTofuUUIDList, false, iDeleteNtDbTofuCallback);
    }

    @Override // sr2.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.i(this.mLogTag, 1, "triggerToRequestTofu:: uin = " + StringUtil.getSimpleUinForPrint(this.mCurFriendUin) + ", hashCode:" + hashCode());
    }

    @Override // sr2.a
    public void f(@NotNull NewBeancurdMsg newBeancurdMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) newBeancurdMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        QLog.i(this.mLogTag, 1, "receiveTofu:: newBeancurdMsg:" + newBeancurdMsg);
    }

    @Override // sr2.a
    public boolean h(@NotNull TofuLimitMsg tofuLimitMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) tofuLimitMsg)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(tofuLimitMsg, "tofuLimitMsg");
        String str = tofuLimitMsg.friendUin;
        Intrinsics.checkNotNullExpressionValue(str, "tofuLimitMsg.friendUin");
        CopyOnWriteArrayList<TofuLimitMsg> D = D(str);
        if ((tofuLimitMsg.flag & 1) == 1) {
            Iterator<TofuLimitMsg> it = D.iterator();
            while (it.hasNext()) {
                TofuLimitMsg next = it.next();
                if (TextUtils.equals(next.businessMsgId, tofuLimitMsg.businessMsgId) && NewBeancurdMsg.ExtraTofuInfo.parseToGetPushInfo(next.extra).isValid) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            return false;
        }
        QLog.d(this.mLogTag, 1, "checkTofuIsRepeatInCurrentTofuDb:: isRepeat = true; tofuLimitMsg:" + tofuLimitMsg);
        return true;
    }

    @Override // sr2.a
    public void i(@NotNull NewBeancurdMsg newBeancurdMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newBeancurdMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        QLog.i(this.mLogTag, 1, "moveCachePushTofuToMsgList:: newBeancurdMsg:" + newBeancurdMsg);
    }

    public final void p(@NotNull AppInterface appInterface, @NotNull NewBeancurdMsg newBeancurdMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) appInterface, (Object) newBeancurdMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(newBeancurdMsg, "newBeancurdMsg");
        Manager manager = appInterface.getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        ((NewTofuManager) manager).m(newBeancurdMsg);
    }

    public boolean q(@NotNull String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) friendUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        if (this.mInAIO && TextUtils.equals(this.mCurFriendUin, friendUin)) {
            return false;
        }
        return true;
    }

    public final boolean r(@NotNull TofuLimitMsg tarMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) tarMsg)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(tarMsg, "tarMsg");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(this.mLogTag, 1, "checkCanInsert:: appRuntime is not QQAppInterface, return!!!");
            return true;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        NewTofuManager newTofuManager = (NewTofuManager) manager;
        String str = tarMsg.friendUin;
        Intrinsics.checkNotNullExpressionValue(str, "tarMsg.friendUin");
        CopyOnWriteArrayList<TofuLimitMsg> D = D(str);
        CopyOnWriteArrayList z16 = z(D);
        Iterator it = z16.iterator();
        boolean z17 = false;
        int i3 = 0;
        while (it.hasNext()) {
            if (((TofuLimitMsg) it.next()).businessId == tarMsg.businessId) {
                i3++;
            }
        }
        int s16 = newTofuManager.s();
        QLog.i(this.mLogTag, 1, "checkCanInsert:: forbid insert = {businessMsgCount:" + i3 + " >= configCount:" + s16 + "}");
        if (i3 < s16) {
            int q16 = newTofuManager.q();
            int d16 = bl.d(z16);
            QLog.d(this.mLogTag, 1, "checkCanInsert:: forbid insert = {ListUtils.size(filterMsgList):" + d16 + " >= configAIOTofuCount:" + q16 + "}");
            if (d16 < q16) {
                z17 = true;
            }
        }
        StringBuilder sb5 = new StringBuilder("checkCanInsert expired Msg:");
        Iterator it5 = z16.iterator();
        while (it5.hasNext()) {
            sb5.append(((TofuLimitMsg) it5.next()).toString());
            sb5.append("\n");
        }
        sb5.append("exposurePeriodList size:");
        sb5.append(bl.d(z16));
        sb5.append("\n");
        sb5.append("tofuMsgList.size:");
        sb5.append(D.size());
        sb5.append("\n");
        sb5.append("targetMsg:");
        sb5.append(tarMsg.toString());
        sb5.append(", can insert = ");
        sb5.append(z17);
        QLog.d(this.mLogTag, 1, sb5.toString());
        return z17;
    }

    public final boolean s(@NotNull TofuLimitMsg tofuLimitMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) tofuLimitMsg)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(tofuLimitMsg, "tofuLimitMsg");
        for (sr2.a aVar : TofuManagerFactory.f293297a.j()) {
            if (aVar.h(tofuLimitMsg)) {
                QLog.i(this.mLogTag, 1, "checkTofuIsRepeatInAllTofuDb:: tofu is repeat in TofuDb:" + aVar + ", return!!!" + tofuLimitMsg);
                return true;
            }
        }
        return false;
    }

    public final boolean t(@NotNull TofuLimitMsg tofuLimitMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) tofuLimitMsg)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(tofuLimitMsg, "tofuLimitMsg");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(this.mLogTag, 1, "checkTofuIsRepeatInPendingTofuList:: appRuntime is not QQAppInterface, return!!!" + tofuLimitMsg);
            return true;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.NewTofuManager");
        Iterator<NewBeancurdMsg> it = ((NewTofuManager) manager).t().iterator();
        while (it.hasNext()) {
            NewBeancurdMsg next = it.next();
            if (TextUtils.equals(next.busiUuid, tofuLimitMsg.businessMsgId) && NewBeancurdMsg.ExtraTofuInfo.parseToGetPushInfo(next.pushInfoString).isValid) {
                QLog.i(this.mLogTag, 1, "checkTofuIsRepeatInPendingTofuList:: pendingTofu =" + next + ", is repeat and valid");
                return true;
            }
        }
        return false;
    }

    public void u(@NotNull String friendUin, @NotNull com.tencent.mobileqq.tofumsg.manager.factory.b iDeleteNtDbTofuCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) friendUin, (Object) iDeleteNtDbTofuCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(iDeleteNtDbTofuCallback, "iDeleteNtDbTofuCallback");
        QLog.i(this.mLogTag, 1, "deleteAllNtDbTofuInSync:: uin: " + StringUtil.getSimpleUinForPrint(friendUin));
        v(friendUin, new CopyOnWriteArrayList<>(), true, iDeleteNtDbTofuCallback);
    }

    @NotNull
    public final <T extends TofuLimitMsg> CopyOnWriteArrayList<T> z(@NotNull CopyOnWriteArrayList<T> tofuMsgList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 23, (Object) this, (Object) tofuMsgList);
        }
        Intrinsics.checkNotNullParameter(tofuMsgList, "tofuMsgList");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i(this.mLogTag, 1, "filterTofuMsgListInExposurePeriod:: appRuntime is not QQAppInterface, return");
            return new CopyOnWriteArrayList<>();
        }
        CopyOnWriteArrayList<T> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Iterator<T> it = tofuMsgList.iterator();
        while (it.hasNext()) {
            T next = it.next();
            Manager manager = peekAppRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.INewTofuManager");
            if (((com.tencent.mobileqq.tofumsg.b) manager).W1(next)) {
                copyOnWriteArrayList.add(next);
            }
        }
        return copyOnWriteArrayList;
    }
}
