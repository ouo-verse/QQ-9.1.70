package com.tencent.mobileqq.wink.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010!\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR(\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010-\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R$\u00104\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010:\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00106\u001a\u0004\b7\u00108\"\u0004\b$\u00109R$\u0010A\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010H\u001a\u00020B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010K\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010<\u001a\u0004\bI\u0010>\"\u0004\bJ\u0010@\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/wink/share/s;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "actionSheet", "", "d", "Landroid/content/Context;", "context", "a", "c", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "b", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface$OnDismissListener;", "getDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "f", "(Landroid/content/DialogInterface$OnDismissListener;)V", "dismissListener", "", "I", "getFriendsRowVisibility", "()I", "g", "(I)V", "friendsRowVisibility", "getPathsRowVisibility", "l", "pathsRowVisibility", "getOperationsRowVisibility", "j", "operationsRowVisibility", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "e", "Ljava/util/List;", "getPathActions", "()Ljava/util/List;", "k", "(Ljava/util/List;)V", "pathActions", "getOperationActions", "i", "operationActions", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", tl.h.F, "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;)V", "onItemClickListener", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface$OnCancelListener;", "getCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "(Landroid/content/DialogInterface$OnCancelListener;)V", "cancelListener", "", "Ljava/lang/String;", "getPreviewPicPath", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "previewPicPath", "", "Z", "getShowRecentFriends", "()Z", "o", "(Z)V", "showRecentFriends", "getShareSrc", DomainData.DOMAIN_NAME, "shareSrc", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DialogInterface.OnDismissListener dismissListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int friendsRowVisibility;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int pathsRowVisibility;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int operationsRowVisibility;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareActionSheet.OnItemClickListener onItemClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DialogInterface.OnCancelListener cancelListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String previewPicPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends ShareActionSheetBuilder.ActionSheetItem> pathActions = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends ShareActionSheetBuilder.ActionSheetItem> operationActions = new ArrayList();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean showRecentFriends = true;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String shareSrc = "biz_src_ads_xsj";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ(\u0010\u0011\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dR\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/share/s$a;", "", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "f", "Landroid/content/DialogInterface$OnCancelListener;", "cancelListener", "d", "", "friendsRowVisibility", "pathsRowVisibility", "operationsRowVisibility", tl.h.F, "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "pathActions", "operationActions", "c", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "onItemClickListener", "e", "", "picPath", "g", "", "showRecentFriends", "j", "shareSrc", "i", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "a", "b", "Lcom/tencent/mobileqq/wink/share/s;", "Lcom/tencent/mobileqq/wink/share/s;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private s panel = new s();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/share/s$a$a;", "", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.share.s$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes21.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final List<ShareActionSheetBuilder.ActionSheetItem> a() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171));
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
                return arrayList;
            }

            Companion() {
            }
        }

        @NotNull
        public final ShareActionSheet a(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return this.panel.c(activity);
        }

        @NotNull
        public final ShareActionSheet b(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return this.panel.b(activity);
        }

        @JvmOverloads
        @NotNull
        public final a c(@NotNull List<? extends ShareActionSheetBuilder.ActionSheetItem> pathActions, @Nullable List<? extends ShareActionSheetBuilder.ActionSheetItem> operationActions) {
            Intrinsics.checkNotNullParameter(pathActions, "pathActions");
            this.panel.k(pathActions);
            if (operationActions != null) {
                this.panel.i(operationActions);
            }
            return this;
        }

        @NotNull
        public final a d(@NotNull DialogInterface.OnCancelListener cancelListener) {
            Intrinsics.checkNotNullParameter(cancelListener, "cancelListener");
            this.panel.e(cancelListener);
            return this;
        }

        @NotNull
        public final a e(@Nullable ShareActionSheet.OnItemClickListener onItemClickListener) {
            this.panel.h(onItemClickListener);
            return this;
        }

        @NotNull
        public final a f(@Nullable DialogInterface.OnDismissListener dismissListener) {
            this.panel.f(dismissListener);
            return this;
        }

        @NotNull
        public final a g(@NotNull String picPath) {
            Intrinsics.checkNotNullParameter(picPath, "picPath");
            this.panel.m(picPath);
            return this;
        }

        @NotNull
        public final a h(int friendsRowVisibility, int pathsRowVisibility, int operationsRowVisibility) {
            this.panel.g(friendsRowVisibility);
            this.panel.l(pathsRowVisibility);
            this.panel.j(operationsRowVisibility);
            return this;
        }

        @NotNull
        public final a i(@NotNull String shareSrc) {
            Intrinsics.checkNotNullParameter(shareSrc, "shareSrc");
            this.panel.n(shareSrc);
            return this;
        }

        @NotNull
        public final a j(boolean showRecentFriends) {
            this.panel.o(showRecentFriends);
            return this;
        }
    }

    private final void a(Context context) {
        if (context instanceof Activity) {
            Intent intent = ((Activity) context).getIntent();
            if (TextUtils.isEmpty(intent.getStringExtra("big_brother_source_key"))) {
                intent.putExtra("big_brother_source_key", this.shareSrc);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d(Activity activity, ShareActionSheet actionSheet) {
        if (actionSheet instanceof ShareActionSheetV2) {
            ((ShareActionSheetV2) actionSheet).setIsShowRecentFriends(this.showRecentFriends);
        }
        actionSheet.setOnDismissListener(this.dismissListener);
        actionSheet.setCancelListener(this.cancelListener);
        actionSheet.setRowVisibility(this.friendsRowVisibility, this.pathsRowVisibility, this.operationsRowVisibility);
        Intent intent = activity.getIntent();
        intent.putExtra("big_brother_source_key", this.shareSrc);
        actionSheet.setIntentForStartForwardRecentActivity(intent);
        actionSheet.setActionSheetItems(this.pathActions, this.operationActions);
        actionSheet.setItemClickListenerV2(this.onItemClickListener);
        a(activity);
    }

    @NotNull
    public final ShareActionSheetV2 b(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        param.showBeforeGetRecentUser = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("photo_show_before_get_recent_user", true);
        ShareActionSheetWithPreview shareActionSheetWithPreview = new ShareActionSheetWithPreview(param);
        String str = this.previewPicPath;
        if (str != null) {
            shareActionSheetWithPreview.D0(com.tencent.mobileqq.wink.utils.f.c(str));
        }
        d(activity, shareActionSheetWithPreview);
        return shareActionSheetWithPreview;
    }

    @NotNull
    public final ShareActionSheet c(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        param.showBeforeGetRecentUser = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("photo_show_before_get_recent_user", true);
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        Intrinsics.checkNotNullExpressionValue(create, "create(param)");
        d(activity, create);
        return create;
    }

    public final void e(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        this.cancelListener = onCancelListener;
    }

    public final void f(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        this.dismissListener = onDismissListener;
    }

    public final void g(int i3) {
        this.friendsRowVisibility = i3;
    }

    public final void h(@Nullable ShareActionSheet.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public final void i(@NotNull List<? extends ShareActionSheetBuilder.ActionSheetItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.operationActions = list;
    }

    public final void j(int i3) {
        this.operationsRowVisibility = i3;
    }

    public final void k(@NotNull List<? extends ShareActionSheetBuilder.ActionSheetItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.pathActions = list;
    }

    public final void l(int i3) {
        this.pathsRowVisibility = i3;
    }

    public final void m(@Nullable String str) {
        this.previewPicPath = str;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareSrc = str;
    }

    public final void o(boolean z16) {
        this.showRecentFriends = z16;
    }
}
