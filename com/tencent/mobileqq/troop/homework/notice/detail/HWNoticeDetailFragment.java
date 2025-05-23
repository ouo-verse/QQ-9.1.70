package com.tencent.mobileqq.troop.homework.notice.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.notice.detail.event.HWNoticeDetailEvent;
import com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailConfirmPart;
import com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailContentPart;
import com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailLoadingPart;
import com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailRemindPart;
import com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.HWNoticeDetailViewModel;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0014J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e0\u001dH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/HWNoticeDetailFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/homework/notice/detail/event/HWNoticeDetailEvent;", "", OcrConfig.CHINESE, "", "authorUin", "", "showRightIconOfNavBar", "Gh", "Eh", "Bh", IPublicAccountJavascriptInterface.KEY_PUB_UIN, "Ah", "", "xh", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "useQUISecNavBar", "onDestroyView", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/HWNoticeDetailViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "yh", "()Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/HWNoticeDetailViewModel;", "viewModel", "<init>", "()V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWNoticeDetailFragment extends QIphoneTitleBarFragment implements SimpleEventReceiver<HWNoticeDetailEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/HWNoticeDetailFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "troopUin", "noticeId", "Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "from", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.detail.HWNoticeDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(@Nullable Activity activity, @NotNull String troopUin, @NotNull String noticeId, @NotNull IHWTroopUIApi.DetailPageFrom from) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, troopUin, noticeId, from);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(noticeId, "noticeId");
            Intrinsics.checkNotNullParameter(from, "from");
            if (activity != null) {
                Intent intent = new Intent();
                intent.putExtra("TROOP_UIN", troopUin);
                intent.putExtra("NOTICE_ID", noticeId);
                intent.putExtra("DETAIL_FROM", from);
                intent.addFlags(268435456);
                QPublicFragmentActivity.b.b(BaseApplication.context, intent, QPublicFragmentActivity.class, HWNoticeDetailFragment.class);
                QLog.i("HW.Notice..Detail.", 1, "SchoolPartner Notice list page click item");
            }
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f297179a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52710);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[IHWTroopUIApi.DetailPageFrom.values().length];
            try {
                iArr[IHWTroopUIApi.DetailPageFrom.GROUP_ARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IHWTroopUIApi.DetailPageFrom.C2C_ARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IHWTroopUIApi.DetailPageFrom.NOTICE_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IHWTroopUIApi.DetailPageFrom.GROUP_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[IHWTroopUIApi.DetailPageFrom.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f297179a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/homework/notice/detail/HWNoticeDetailFragment$c", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Landroid/view/View;", "view", "", "a", "", "I", "getDrawable", "()I", "drawable", "b", "d", "drawableInTransparent", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.biz.qui.quisecnavbar.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int drawable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int drawableInTransparent;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWNoticeDetailFragment.this);
            } else {
                this.drawable = R.drawable.qui_more_icon_navigation_01_selector;
                this.drawableInTransparent = R.drawable.qui_more;
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                HWNoticeDetailFragment.this.Eh();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.drawableInTransparent;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.drawable;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52718);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWNoticeDetailFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<HWNoticeDetailViewModel>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.HWNoticeDetailFragment$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeDetailFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final HWNoticeDetailViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? g.d(HWNoticeDetailFragment.this) : (HWNoticeDetailViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.viewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(long pubUin) {
        String str;
        String str2;
        HashMap<String, Object> hashMapOf;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        String valueOf = String.valueOf(pubUin);
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(valueOf, str) && !yh().l2()) {
            str2 = "pg_group_parent_notice_detail";
        } else {
            str2 = "pg_group_teacher_notice_detail";
        }
        com.tencent.mobileqq.troop.homework.notice.report.a aVar = com.tencent.mobileqq.troop.homework.notice.report.a.f297331a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_id", yh().j2()), TuplesKt.to(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(xh())));
        aVar.b(activity, str2, hashMapOf, true);
        VideoReport.reportPgIn(activity.getWindow().getDecorView());
    }

    private final void Bh() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u662f\u5426\u786e\u5b9a\u5220\u9664\uff1f\u5220\u9664\u540e\u5176\u5b83\u6210\u5458\u4e0d\u518d\u80fd\u770b\u5230\u8be5\u901a\u77e5\uff0c\u4e14\u7edf\u8ba1\u6570\u636e\u5931\u6548\u3002", "\u53d6\u6d88", "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                HWNoticeDetailFragment.Ch(HWNoticeDetailFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                HWNoticeDetailFragment.Dh(dialogInterface, i3);
            }
        });
        createCustomDialog.show();
        com.tencent.mobileqq.troop.homework.notice.report.a aVar = com.tencent.mobileqq.troop.homework.notice.report.a.f297331a;
        TextView btnight = createCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight, "dialog.btnight");
        h.a.m(aVar, btnight, "em_group_confirm_del_notice", ExposurePolicy.REPORT_NONE, null, null, getView(), 24, null);
        TextView btnight2 = createCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight2, "dialog.btnight");
        aVar.f(btnight2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(HWNoticeDetailFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.yh().a2();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton("\u5220\u9664\u5185\u5bb9");
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                HWNoticeDetailFragment.Fh(ActionSheet.this, this, view, i3);
            }
        });
        actionSheet.addCancelButton("\u53d6\u6d88");
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(ActionSheet actionSheet, HWNoticeDetailFragment this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        actionSheet.dismiss();
        if (i3 == 0) {
            this$0.Bh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(long authorUin, boolean showRightIconOfNavBar) {
        String str;
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        if (Intrinsics.areEqual(String.valueOf(authorUin), str) && showRightIconOfNavBar) {
            this.quiSecNavBar.setRightType(2);
            this.quiSecNavBar.d(new c());
            return;
        }
        zh();
    }

    private final int xh() {
        int i3 = b.f297179a[yh().g2().ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return 3;
        }
        if (i3 == 4) {
            return 4;
        }
        if (i3 == 5) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HWNoticeDetailViewModel yh() {
        return (HWNoticeDetailViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh() {
        this.quiSecNavBar.setRightType(0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HWDetailContentPart());
        arrayList.add(new HWDetailRemindPart());
        arrayList.add(new HWDetailConfirmPart());
        arrayList.add(new HWDetailLoadingPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.g0e;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<HWNoticeDetailEvent>> getEventClass() {
        ArrayList<Class<HWNoticeDetailEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(HWNoticeDetailEvent.NoticeDetailError.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        View view;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroyView();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        VideoReport.reportPgOut(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
        } else if (event instanceof HWNoticeDetailEvent.NoticeDetailError) {
            yh().q2(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        setTitle("\u901a\u77e5\u8be6\u60c5");
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new HWNoticeDetailFragment$onViewCreated$1(this, null));
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }
}
