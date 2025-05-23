package com.tencent.qqnt.kernel.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.api.impl.BuddyService;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.AvatarUrlType;
import com.tencent.qqnt.kernel.nativeinterface.BuddyCategory;
import com.tencent.qqnt.kernel.nativeinterface.BuddyListCategory;
import com.tencent.qqnt.kernel.nativeinterface.BuddyListReqType;
import com.tencent.qqnt.kernel.nativeinterface.BuddyReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.BuddySetting;
import com.tencent.qqnt.kernel.nativeinterface.BuddyVerify;
import com.tencent.qqnt.kernel.nativeinterface.DelBuddyInfo;
import com.tencent.qqnt.kernel.nativeinterface.DoubtBuddyReqListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IBuddyListCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICheckIsBuddyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService;
import com.tencent.qqnt.kernel.nativeinterface.IModifyCategoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RemarkParams;
import com.tencent.qqnt.kernel.nativeinterface.SpecialCareSetting;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ab\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\u0018\u0000 L2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001MB\u0019\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010I\u001a\u00020H\u00a2\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0015H\u0016J>\u0010\u001c\u001a \u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u001a2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0017j\b\u0012\u0004\u0012\u00020\u0011`\u0018H\u0016J>\u0010\u001d\u001a \u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u001a2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0017j\b\u0012\u0004\u0012\u00020\u0011`\u0018H\u0016J\u001c\u0010 \u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J6\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010#2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0017j\b\u0012\u0004\u0012\u00020\u0011`\u00182\u0006\u0010\"\u001a\u00020!H\u0016J\u0019\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b&\u0010'JF\u0010(\u001a \u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\f0\f\u0018\u00010\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0017j\b\u0012\u0004\u0012\u00020\u0011`\u0018H\u0016J\u001c\u0010+\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010.\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010-\u001a\u00020,2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J&\u00103\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u00112\b\u00101\u001a\u0004\u0018\u0001002\b\u0010\u000f\u001a\u0004\u0018\u000102H\u0016J\u001a\u00104\u001a\u00020\t2\u0006\u0010-\u001a\u00020,2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u00108\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00112\u0006\u00106\u001a\u0002052\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010:\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00112\u0006\u00109\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010<\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010>\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u0013H\u0016J\b\u0010B\u001a\u00020\fH\u0016J\"\u0010E\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u00010DH\u0016J\b\u0010F\u001a\u00020,H\u0016\u00a8\u0006N"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/BuddyService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyService;", "Lcom/tencent/qqnt/kernel/api/m;", "listener", "com/tencent/qqnt/kernel/api/impl/BuddyService$b", "t4", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyListener;)Lcom/tencent/qqnt/kernel/api/impl/BuddyService$b;", "", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "getBuddyList", "", "callFrom", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyListReqType;", "requestType", "Lcom/tencent/qqnt/kernel/nativeinterface/IBuddyListCallback;", "getBuddyListV2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "Ljava/util/HashMap;", "kotlin.jvm.PlatformType", "r4", ICustomDataEditor.STRING_PARAM_4, "Lcom/tencent/qqnt/kernel/nativeinterface/RemarkParams;", "remarkParams", "setBuddyRemark", "Lcom/tencent/qqnt/kernel/nativeinterface/AvatarUrlType;", "type", "", "g", "uid", "isBuddy", "(Ljava/lang/String;)Ljava/lang/Boolean;", "q4", "Lcom/tencent/qqnt/kernel/nativeinterface/DelBuddyInfo;", "delInfo", "delBuddy", "", "categoryId", "setBuddyCategory", "name", "", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/IModifyCategoryCallback;", "addCategoryV2", "delCategory", "Lcom/tencent/qqnt/kernel/nativeinterface/SpecialCareSetting;", "set", "result", "L", "noDisturb", "setMsgNotify", "block", "setBlock", "isTop", "setTop", "reqType", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyListCategory;", "getBuddyListFromCache", "H0", "tag", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckIsBuddyCallback;", BdhLogUtil.LogTag.Tag_Req, "getAllBuddyCount", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class BuddyService extends BaseService<IKernelBuddyListener, IKernelBuddyService> implements com.tencent.qqnt.kernel.api.m {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/BuddyService$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.BuddyService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0019\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006\u001a"}, d2 = {"com/tencent/qqnt/kernel/api/impl/BuddyService$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyCategory;", "Lkotlin/collections/ArrayList;", "data", "", "onBuddyListChange", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "onBuddyListChangedV2", "", "uid", "nick", "onNickUpdated", "remark", "onBuddyRemarkUpdated", "onAvatarUrlUpdated", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyReqInfo;", "onBuddyReqChange", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddySetting;", "setting", "onCheckBuddySettingResult", "", "category", "onSmartInfos", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements IKernelBuddyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IKernelBuddyListener f357237b;

        b(IKernelBuddyListener iKernelBuddyListener) {
            this.f357237b = iKernelBuddyListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BuddyService.this, (Object) iKernelBuddyListener);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(String uid, IKernelBuddyListener listener) {
            Intrinsics.checkNotNullParameter(uid, "$uid");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "Buddy", new Object[]{TuplesKt.to("onAvatarUrlUpdated uid", uid)}, null, 4, null);
            listener.onAvatarUrlUpdated(uid);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(ArrayList data, IKernelBuddyListener listener) {
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "Buddy", new Object[]{TuplesKt.to("onBuddyListChange data.size", Integer.valueOf(data.size()))}, null, 4, null);
            listener.onBuddyListChange(data);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(IKernelBuddyListener listener, boolean z16) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "Buddy", new Object[]{"onBuddyListChangedV2 uid"}, null, 4, null);
            listener.onBuddyListChangedV2(z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(String uid, String remark, IKernelBuddyListener listener) {
            Intrinsics.checkNotNullParameter(uid, "$uid");
            Intrinsics.checkNotNullParameter(remark, "$remark");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "Buddy", new Object[]{TuplesKt.to("onBuddyRemarkUpdated uid", uid), TuplesKt.to("remark", remark)}, null, 4, null);
            listener.onBuddyRemarkUpdated(uid, remark);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(IKernelBuddyListener listener, BuddyReqInfo data) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(data, "$data");
            KLog.e(KLog.f359087a, "Buddy", new Object[]{"onBuddyReqChange"}, null, 4, null);
            listener.onBuddyReqChange(data);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(IKernelBuddyListener listener, BuddySetting buddySetting) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "Buddy", new Object[]{"onCheckBuddySettingResult"}, null, 4, null);
            listener.onCheckBuddySettingResult(buddySetting);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(String uid, String nick, IKernelBuddyListener listener) {
            Intrinsics.checkNotNullParameter(uid, "$uid");
            Intrinsics.checkNotNullParameter(nick, "$nick");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "Buddy", new Object[]{TuplesKt.to("onNickUpdated uid", uid), TuplesKt.to("nick", nick)}, null, 4, null);
            listener.onNickUpdated(uid, nick);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(IKernelBuddyListener listener, String str, String str2, int i3) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "Buddy", new Object[]{"onCheckBuddySettingResult"}, null, 4, null);
            listener.onSmartInfos(str, str2, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onAddBuddyNeedVerify(BuddyVerify buddyVerify) {
            com.tencent.qqnt.kernel.nativeinterface.ab.a(this, buddyVerify);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onAddMeSettingChanged(int i3, HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.ab.b(this, i3, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onAvatarUrlUpdated(@NotNull final String uid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) uid);
                return;
            }
            Intrinsics.checkNotNullParameter(uid, "uid");
            BuddyService buddyService = BuddyService.this;
            final IKernelBuddyListener iKernelBuddyListener = this.f357237b;
            buddyService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gy
                @Override // java.lang.Runnable
                public final void run() {
                    BuddyService.b.i(uid, iKernelBuddyListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBlockChanged(HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.ab.d(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBuddyDeleted(String str) {
            com.tencent.qqnt.kernel.nativeinterface.ab.e(this, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onBuddyListChange(@NotNull final ArrayList<BuddyCategory> data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            BuddyService buddyService = BuddyService.this;
            final IKernelBuddyListener iKernelBuddyListener = this.f357237b;
            buddyService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gt
                @Override // java.lang.Runnable
                public final void run() {
                    BuddyService.b.j(data, iKernelBuddyListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onBuddyListChangedV2(final boolean first) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, first);
                return;
            }
            BuddyService buddyService = BuddyService.this;
            final IKernelBuddyListener iKernelBuddyListener = this.f357237b;
            buddyService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gx
                @Override // java.lang.Runnable
                public final void run() {
                    BuddyService.b.k(IKernelBuddyListener.this, first);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onBuddyRemarkUpdated(@NotNull final String uid, @NotNull final String remark) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uid, (Object) remark);
                return;
            }
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(remark, "remark");
            BuddyService buddyService = BuddyService.this;
            final IKernelBuddyListener iKernelBuddyListener = this.f357237b;
            buddyService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gw
                @Override // java.lang.Runnable
                public final void run() {
                    BuddyService.b.l(uid, remark, iKernelBuddyListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onBuddyReqChange(@NotNull final BuddyReqInfo data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            BuddyService buddyService = BuddyService.this;
            final IKernelBuddyListener iKernelBuddyListener = this.f357237b;
            buddyService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gv
                @Override // java.lang.Runnable
                public final void run() {
                    BuddyService.b.m(IKernelBuddyListener.this, data);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBuddyReqUnreadCntChange(int i3) {
            com.tencent.qqnt.kernel.nativeinterface.ab.j(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onCheckBuddySettingResult(@Nullable final BuddySetting setting) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) setting);
                return;
            }
            BuddyService buddyService = BuddyService.this;
            final IKernelBuddyListener iKernelBuddyListener = this.f357237b;
            buddyService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gr
                @Override // java.lang.Runnable
                public final void run() {
                    BuddyService.b.n(IKernelBuddyListener.this, setting);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onDelBatchBuddyInfos(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ab.l(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onDoubtBuddyReqChange(DoubtBuddyReqListRsp doubtBuddyReqListRsp) {
            com.tencent.qqnt.kernel.nativeinterface.ab.m(this, doubtBuddyReqListRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onDoubtBuddyReqUnreadNumChange(int i3) {
            com.tencent.qqnt.kernel.nativeinterface.ab.n(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onNickUpdated(@NotNull final String uid, @NotNull final String nick) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uid, (Object) nick);
                return;
            }
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(nick, "nick");
            BuddyService buddyService = BuddyService.this;
            final IKernelBuddyListener iKernelBuddyListener = this.f357237b;
            buddyService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gu
                @Override // java.lang.Runnable
                public final void run() {
                    BuddyService.b.o(uid, nick, iKernelBuddyListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onSmartInfos(@Nullable final String uid, @Nullable final String remark, final int category) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, uid, remark, Integer.valueOf(category));
                return;
            }
            BuddyService buddyService = BuddyService.this;
            final IKernelBuddyListener iKernelBuddyListener = this.f357237b;
            buddyService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.gs
                @Override // java.lang.Runnable
                public final void run() {
                    BuddyService.b.p(IKernelBuddyListener.this, uid, remark, category);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onSpacePermissionInfos(HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.ab.q(this, hashMap);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45027);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuddyService(@Nullable IKernelBuddyService iKernelBuddyService, @NotNull py content) {
        super("Buddy", content, iKernelBuddyService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelBuddyService, (Object) content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b t4(IKernelBuddyListener listener) {
        return new b(listener);
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void A(@NotNull IKernelBuddyListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            BaseService.removeListener$default(this, listener, false, new Function1<Long, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$removeBuddyListener$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke(l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, j3);
                        return;
                    }
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service != null) {
                        service.removeKernelBuddyListener(j3);
                    }
                }
            }, 2, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public boolean H0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        IKernelBuddyService service = getService();
        if (service == null || !service.hasBuddyList()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void I(@NotNull IKernelBuddyListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            addListener(listener, new Function1<IKernelBuddyListener, Long>() { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$addBuddyListener$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Long invoke(@NotNull IKernelBuddyListener it) {
                    BuddyService.b t46;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Long) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    t46 = BuddyService.this.t4(it);
                    return Long.valueOf(service.addKernelBuddyListener(t46));
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void L(@NotNull final String uid, @NotNull final SpecialCareSetting set, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, uid, set, result);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(set, "set");
        check("setSpecialCare", result, new Function1<IOperateCallback, Unit>(uid, set) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$setSpecialCare$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ SpecialCareSetting $set;
            final /* synthetic */ String $uid;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$uid = uid;
                this.$set = set;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BuddyService.this, uid, set);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                IKernelBuddyService service = BuddyService.this.getService();
                if (service == null) {
                    return null;
                }
                service.SetSpecialCare(this.$uid, this.$set, iOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void R(@NotNull final String uid, @NotNull String tag, @Nullable ICheckIsBuddyCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, uid, tag, result);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(tag, "tag");
        check("checkIsBuddyAsync", result, new Function1<ICheckIsBuddyCallback, Unit>(uid) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$isFriend$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $uid;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$uid = uid;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyService.this, (Object) uid);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable ICheckIsBuddyCallback iCheckIsBuddyCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iCheckIsBuddyCallback);
                }
                IKernelBuddyService service = BuddyService.this.getService();
                if (service == null) {
                    return null;
                }
                service.checkIsBuddyAsync(this.$uid, iCheckIsBuddyCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void addCategoryV2(@Nullable final String name, @Nullable final byte[] context, @Nullable IModifyCategoryCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, name, context, cb5);
        } else {
            check("addCategoryV2", cb5, new Function1<IModifyCategoryCallback, Unit>(name, context) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$addCategoryV2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ byte[] $context;
                final /* synthetic */ String $name;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$name = name;
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BuddyService.this, name, context);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IModifyCategoryCallback iModifyCategoryCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iModifyCategoryCallback);
                    }
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addCategoryV2(this.$name, this.$context, iModifyCategoryCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void delBuddy(@Nullable final DelBuddyInfo delInfo, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) delInfo, (Object) cb5);
        } else {
            check("delBuddy", cb5, new Function1<IOperateCallback, Unit>(delInfo) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$delBuddy$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ DelBuddyInfo $delInfo;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$delInfo = delInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyService.this, (Object) delInfo);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.delBuddy(this.$delInfo, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void delCategory(final int categoryId, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, categoryId, (Object) cb5);
        } else {
            check("delCategory", cb5, new Function1<IOperateCallback, Unit>(categoryId) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$delCategory$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $categoryId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$categoryId = categoryId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyService.this, categoryId);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.delCategory(this.$categoryId, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.m
    @Nullable
    public Map<String, String> g(@NotNull ArrayList<String> uids, @NotNull AvatarUrlType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this, (Object) uids, (Object) type);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(type, "type");
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public int getAllBuddyCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        IKernelBuddyService service = getService();
        if (service != null) {
            return service.getAllBuddyCount();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void getBuddyList(final boolean force, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(force), cb5);
        } else {
            check("getBuddyList", cb5, new Function1<IOperateCallback, Unit>(force) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$getBuddyList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $force;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$force = force;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BuddyService.this, Boolean.valueOf(force));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getBuddyList(this.$force, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.m
    @Nullable
    public ArrayList<BuddyListCategory> getBuddyListFromCache(@NotNull String callFrom, @NotNull BuddyListReqType reqType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (ArrayList) iPatchRedirector.redirect((short) 33, (Object) this, (Object) callFrom, (Object) reqType);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        IKernelBuddyService service = getService();
        if (service != null) {
            return service.getBuddyListFromCache(callFrom, reqType);
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void getBuddyListV2(@NotNull final String callFrom, final boolean force, @NotNull final BuddyListReqType requestType, @Nullable IBuddyListCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, callFrom, Boolean.valueOf(force), requestType, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        check("getBuddyListV2", cb5, new Function1<IBuddyListCallback, Unit>(callFrom, force, requestType) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$getBuddyListV2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $callFrom;
            final /* synthetic */ boolean $force;
            final /* synthetic */ BuddyListReqType $requestType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callFrom = callFrom;
                this.$force = force;
                this.$requestType = requestType;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BuddyService.this, callFrom, Boolean.valueOf(force), requestType);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IBuddyListCallback iBuddyListCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iBuddyListCallback);
                }
                IKernelBuddyService service = BuddyService.this.getService();
                if (service == null) {
                    return null;
                }
                service.getBuddyListV2(this.$callFrom, this.$force, this.$requestType, iBuddyListCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.m
    @Nullable
    public Boolean isBuddy(@NotNull final String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) uid);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        return (Boolean) check("isBuddy", new Function0<Boolean>(uid) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$isBuddy$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $uid;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$uid = uid;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyService.this, (Object) uid);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Boolean invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelBuddyService service = BuddyService.this.getService();
                if (service != null) {
                    return Boolean.valueOf(service.isBuddy(this.$uid));
                }
                return null;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.m
    @Nullable
    /* renamed from: q4, reason: merged with bridge method [inline-methods] */
    public HashMap<String, Boolean> areBuddies(@NotNull final String callFrom, @NotNull final ArrayList<String> uids) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (HashMap) iPatchRedirector.redirect((short) 11, (Object) this, (Object) callFrom, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(uids, "uids");
        return (HashMap) check("areBuddies", new Function0<HashMap<String, Boolean>>(callFrom, uids) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$areBuddies$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $callFrom;
            final /* synthetic */ ArrayList<String> $uids;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$callFrom = callFrom;
                this.$uids = uids;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BuddyService.this, callFrom, uids);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final HashMap<String, Boolean> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelBuddyService service = BuddyService.this.getService();
                if (service != null) {
                    return service.areBuddies(this.$callFrom, this.$uids);
                }
                return null;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.m
    @Nullable
    /* renamed from: r4, reason: merged with bridge method [inline-methods] */
    public HashMap<String, String> getBuddyNick(@NotNull final ArrayList<String> uids) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashMap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        return (HashMap) check("getBuddyNick", new Function0<HashMap<String, String>>(uids) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$getBuddyNick$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<String> $uids;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$uids = uids;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyService.this, (Object) uids);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final HashMap<String, String> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelBuddyService service = BuddyService.this.getService();
                if (service != null) {
                    return service.getBuddyNick(this.$uids);
                }
                return null;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.m
    @Nullable
    /* renamed from: s4, reason: merged with bridge method [inline-methods] */
    public HashMap<String, String> getBuddyRemark(@NotNull final ArrayList<String> uids) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HashMap) iPatchRedirector.redirect((short) 7, (Object) this, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        return (HashMap) check("getBuddyRemark", new Function0<HashMap<String, String>>(uids) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$getBuddyRemark$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<String> $uids;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$uids = uids;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyService.this, (Object) uids);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final HashMap<String, String> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelBuddyService service = BuddyService.this.getService();
                if (service != null) {
                    return service.getBuddyRemark(this.$uids);
                }
                return null;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void setBlock(@NotNull final String uid, final boolean block, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, uid, Boolean.valueOf(block), result);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            check("setBlock", result, new Function1<IOperateCallback, Unit>(uid, block) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$setBlock$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $block;
                final /* synthetic */ String $uid;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$uid = uid;
                    this.$block = block;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BuddyService.this, uid, Boolean.valueOf(block));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setBlock(this.$uid, this.$block, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void setBuddyCategory(@Nullable final String uid, final int categoryId, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, uid, Integer.valueOf(categoryId), cb5);
        } else {
            check("setBuddyCategory", cb5, new Function1<IOperateCallback, Unit>(uid, categoryId) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$setBuddyCategory$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $categoryId;
                final /* synthetic */ String $uid;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$uid = uid;
                    this.$categoryId = categoryId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BuddyService.this, uid, Integer.valueOf(categoryId));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setBuddyCategory(this.$uid, this.$categoryId, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void setBuddyRemark(@Nullable final RemarkParams remarkParams, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) remarkParams, (Object) cb5);
        } else {
            check("setBuddyRemark", cb5, new Function1<IOperateCallback, Unit>(remarkParams) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$setBuddyRemark$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RemarkParams $remarkParams;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$remarkParams = remarkParams;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyService.this, (Object) remarkParams);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setBuddyRemark(this.$remarkParams, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void setMsgNotify(@NotNull final String uid, final boolean noDisturb, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, uid, Boolean.valueOf(noDisturb), result);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            check("setMsgNotify", result, new Function1<IOperateCallback, Unit>(uid, noDisturb) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$setMsgNotify$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $noDisturb;
                final /* synthetic */ String $uid;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$uid = uid;
                    this.$noDisturb = noDisturb;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BuddyService.this, uid, Boolean.valueOf(noDisturb));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setMsgNotify(this.$uid, this.$noDisturb, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.m
    public void setTop(@NotNull final String uid, final boolean isTop, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, uid, Boolean.valueOf(isTop), result);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            check("setTop", result, new Function1<IOperateCallback, Unit>(uid, isTop) { // from class: com.tencent.qqnt.kernel.api.impl.BuddyService$setTop$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isTop;
                final /* synthetic */ String $uid;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$uid = uid;
                    this.$isTop = isTop;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BuddyService.this, uid, Boolean.valueOf(isTop));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelBuddyService service = BuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setTop(this.$uid, this.$isTop, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
