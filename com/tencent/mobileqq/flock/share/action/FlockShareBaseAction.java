package com.tencent.mobileqq.flock.share.action;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.flock.share.RequestState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0004J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0014\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/flock/share/action/FlockShareBaseAction;", "Lcom/tencent/mobileqq/flock/share/action/f;", "", "it", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "Lcom/tencent/mobileqq/flock/share/e;", "shareParam", "", "f", "a", "", "msg", h.F, "g", "Landroid/content/Context;", "context", "d", "", "e", "(Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;)Ljava/lang/Integer;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class FlockShareBaseAction implements f {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f210415a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49150);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[RequestState.values().length];
            try {
                iArr[RequestState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RequestState.REQUESTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RequestState.SUCCEED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RequestState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f210415a = iArr;
        }
    }

    public FlockShareBaseAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(boolean it, Activity activity, ShareActionSheetBuilder.ActionSheetItem sheetItem, com.tencent.mobileqq.flock.share.e shareParam) {
        String str;
        if (it) {
            g(activity, sheetItem, shareParam);
            return;
        }
        com.tencent.mobileqq.flock.share.a f16 = shareParam.f();
        if (f16 != null) {
            str = f16.a();
        } else {
            str = null;
        }
        h(str);
    }

    public static /* synthetic */ void i(FlockShareBaseAction flockShareBaseAction, String str, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                str = null;
            }
            flockShareBaseAction.h(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorToast");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String str) {
        if (str == null) {
            str = ShareJsPlugin.ERRMSG_INVITE_REQUIRE;
        }
        QQToastUtil.showQQToast(1, str);
    }

    @Override // com.tencent.mobileqq.flock.share.action.f
    public void a(@NotNull final Activity activity, @NotNull final ShareActionSheetBuilder.ActionSheetItem sheetItem, @NotNull final com.tencent.mobileqq.flock.share.e shareParam) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, sheetItem, shareParam);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sheetItem, "sheetItem");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        int i3 = a.f210415a[shareParam.l().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        com.tencent.mobileqq.flock.share.a f16 = shareParam.f();
                        if (f16 != null) {
                            str = f16.a();
                        } else {
                            str = null;
                        }
                        h(str);
                    }
                } else {
                    g(activity, sheetItem, shareParam);
                }
            } else {
                shareParam.r(new Function1<Boolean, Unit>(activity, sheetItem, shareParam) { // from class: com.tencent.mobileqq.flock.share.action.FlockShareBaseAction$doAction$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Activity $activity;
                    final /* synthetic */ com.tencent.mobileqq.flock.share.e $shareParam;
                    final /* synthetic */ ShareActionSheetBuilder.ActionSheetItem $sheetItem;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$activity = activity;
                        this.$sheetItem = sheetItem;
                        this.$shareParam = shareParam;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, FlockShareBaseAction.this, activity, sheetItem, shareParam);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            FlockShareBaseAction.this.f(z16, this.$activity, this.$sheetItem, this.$shareParam);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                        }
                    }
                });
            }
        } else {
            shareParam.r(new Function1<Boolean, Unit>(activity, sheetItem, shareParam) { // from class: com.tencent.mobileqq.flock.share.action.FlockShareBaseAction$doAction$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $activity;
                final /* synthetic */ com.tencent.mobileqq.flock.share.e $shareParam;
                final /* synthetic */ ShareActionSheetBuilder.ActionSheetItem $sheetItem;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$activity = activity;
                    this.$sheetItem = sheetItem;
                    this.$shareParam = shareParam;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlockShareBaseAction.this, activity, sheetItem, shareParam);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        FlockShareBaseAction.this.f(z16, this.$activity, this.$sheetItem, this.$shareParam);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    }
                }
            });
            shareParam.q();
        }
        d(activity, sheetItem, shareParam);
    }

    protected void d(@NotNull Context context, @NotNull ShareActionSheetBuilder.ActionSheetItem sheetItem, @NotNull com.tencent.mobileqq.flock.share.e shareParam) {
        Map<String, Object> mutableMapOf;
        Map<String, Object> a16;
        View pageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, sheetItem, shareParam);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sheetItem, "sheetItem");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        View view = new View(context);
        String str = null;
        PageInfo pageInfo = VideoReport.getPageInfo(null);
        if (pageInfo != null && (pageView = pageInfo.getPageView()) != null) {
            com.tencent.mobileqq.flock.datong.c.b(view, pageView);
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("qq_eid", "em_share_item");
        com.tencent.mobileqq.flock.share.f k3 = shareParam.k();
        if (k3 != null) {
            str = k3.b();
        }
        pairArr[1] = TuplesKt.to("qq_pgid", String.valueOf(str));
        pairArr[2] = TuplesKt.to("activity_result_id", shareParam.g().f449366a);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        Integer e16 = e(sheetItem);
        if (e16 != null) {
            mutableMapOf.put("share_source", Integer.valueOf(e16.intValue()));
        }
        com.tencent.mobileqq.flock.share.f k16 = shareParam.k();
        if (k16 != null && (a16 = k16.a()) != null) {
            mutableMapOf.putAll(a16);
        }
        com.tencent.mobileqq.flock.datong.c.a("qq_clck", view, "em_share_item", new com.tencent.mobileqq.flock.datong.b().g(mutableMapOf));
    }

    @Nullable
    protected Integer e(@NotNull ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) sheetItem);
        }
        Intrinsics.checkNotNullParameter(sheetItem, "sheetItem");
        return null;
    }

    public abstract void g(@NotNull Activity activity, @NotNull ShareActionSheetBuilder.ActionSheetItem sheetItem, @NotNull com.tencent.mobileqq.flock.share.e shareParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(@Nullable final String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.flock.share.action.e
                @Override // java.lang.Runnable
                public final void run() {
                    FlockShareBaseAction.j(msg2);
                }
            });
        }
    }
}
