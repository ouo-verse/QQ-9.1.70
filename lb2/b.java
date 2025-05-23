package lb2;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lb2.b;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Llb2/b;", "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Llb2/b$a;", "", "Landroid/content/Context;", "context", "", "from", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "", "e", "", "msgId", "c", "uin", "b", "FROM_JIEBAN", "Ljava/lang/String;", "FROM_NEARBY", "JIEBAN_UID", "NEARBY_UID", "TAG", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: lb2.b$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Context context, String str, int i3, String str2, ArrayList arrayList) {
            Object first;
            if (arrayList != null && !arrayList.isEmpty()) {
                IPublicAccountMsgExtMrg iPublicAccountMsgExtMrg = (IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class);
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                Intrinsics.checkNotNullExpressionValue(first, "msgList.first()");
                b.INSTANCE.e(context, str, ((IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class)).getOriginalParam(iPublicAccountMsgExtMrg.getBusiIdExtra((MsgRecord) first)));
                return;
            }
            j.c().d("QQStrangerPAJumpHelper", "QQStranger PA getMsg error: " + i3 + ", " + str2);
            b.INSTANCE.e(context, str, "");
        }

        private final void e(Context context, String from, String businessData) {
            String str;
            boolean z16;
            if (Intrinsics.areEqual(from, ProcessConstant.NEARBY)) {
                str = "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=stranger_public_account&app_id=2&local_bundle_name=nearbypro&kr_turbo_display=stranger_public_account2";
            } else {
                str = "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=stranger_public_account&app_id=1&local_bundle_name=nearbypro&kr_turbo_display=stranger_public_account1";
            }
            if (businessData.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = str + "&red_ext=" + businessData;
            }
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, str);
        }

        public final void b(@Nullable Context context, @NotNull String uin) {
            String str;
            boolean z16;
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (Intrinsics.areEqual(uin, AppConstants.NEARBY_PUBLIC_ACCOUNT_UIN)) {
                str = ProcessConstant.NEARBY;
            } else if (!Intrinsics.areEqual(uin, AppConstants.JIEBAN_PUBLIC_ACCOUNT_UIN)) {
                str = "";
            } else {
                str = "jieban";
            }
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                j.c().d("QQStrangerPAJumpHelper", "startStrangerFragment failed, uin: " + uin);
                return;
            }
            e(context, str, "");
        }

        public final void c(@Nullable final Context context, @Nullable final String from, long msgId) {
            String str;
            if (Intrinsics.areEqual(from, ProcessConstant.NEARBY)) {
                str = "u_O15i55e29ARGyUCVll5Qyw";
            } else {
                str = "u_7kmocF-QM2XsQtpVKCFaWg";
            }
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            Contact contact = new Contact(103, str, "");
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(msgId));
            Unit unit = Unit.INSTANCE;
            iMsgService.getMsgsByMsgId(contact, arrayList, new IMsgOperateCallback() { // from class: lb2.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str2, ArrayList arrayList2) {
                    b.Companion.d(context, from, i3, str2, arrayList2);
                }
            });
        }

        Companion() {
        }
    }
}
