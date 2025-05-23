package com.tencent.mobileqq.guild.feed.batchmanage.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageTitlePart;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xi1.BatchManageOperate;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0003J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u000f\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R#\u0010\u001c\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lco1/g;", "", "L9", "K9", "Landroid/view/View;", "containerView", "I9", "E9", "com/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageTitlePart$a", "H9", "()Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageTitlePart$a;", "M9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "onBackEvent", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon;", "d", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon;", "navBar", "Lvi1/f;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "getBatchSelectManager", "()Lvi1/f;", "batchSelectManager", "O0", "()Landroid/view/View;", "hostView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedBatchManageTitlePart extends Part implements co1.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildDefaultThemeNavBarCommon navBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy batchSelectManager;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageTitlePart$a", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "Landroid/view/View;", "view", "", "a", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "onItemSelect", "v", "", "onItemLongClick", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildDefaultThemeNavBarCommon.a {
        a() {
        }

        private final void a(View view) {
            VideoReport.setElementId(view, "em_sgrp_cancel_btn");
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
            VideoReport.reportEvent("clck", view, null);
            GuildFeedBatchManageTitlePart.this.E9();
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public boolean onItemLongClick(@Nullable View v3, int item) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public void onItemSelect(@NotNull View view, int item) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (item != 1) {
                if (item == 4) {
                    GuildFeedBatchManageTitlePart.this.I9(view);
                    return;
                } else {
                    if (item == 8) {
                        a(view);
                        return;
                    }
                    return;
                }
            }
            a(view);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageTitlePart$b", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "view", "Landroid/view/MotionEvent;", "event", "", "onTouch", "Landroid/view/GestureDetector;", "d", "Landroid/view/GestureDetector;", "gestureDetector", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GestureDetector gestureDetector;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageTitlePart$b$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "event", "", "onDoubleTap", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a extends GestureDetector.SimpleOnGestureListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ GuildFeedBatchManageTitlePart f218196d;

            a(GuildFeedBatchManageTitlePart guildFeedBatchManageTitlePart) {
                this.f218196d = guildFeedBatchManageTitlePart;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(vi1.e eVar) {
                eVar.g6();
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(@NotNull MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                RFWIocAbilityProvider.g().getIoc(vi1.e.class).originView(this.f218196d.getPartRootView()).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.y
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj) {
                        GuildFeedBatchManageTitlePart.b.a.b((vi1.e) obj);
                    }
                }).run();
                return true;
            }
        }

        b(GuildFeedBatchManageTitlePart guildFeedBatchManageTitlePart) {
            GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = guildFeedBatchManageTitlePart.navBar;
            if (guildDefaultThemeNavBarCommon == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navBar");
                guildDefaultThemeNavBarCommon = null;
            }
            this.gestureDetector = new GestureDetector(guildDefaultThemeNavBarCommon.getContext(), new a(guildFeedBatchManageTitlePart));
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View view, @NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(event, "event");
            this.gestureDetector.onTouchEvent(event);
            return true;
        }
    }

    public GuildFeedBatchManageTitlePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<vi1.f>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageTitlePart$batchSelectManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final vi1.f invoke() {
                return (vi1.f) RFWIocAbilityProvider.g().getIocInterface(vi1.f.class, GuildFeedBatchManageTitlePart.this.getPartRootView(), null);
            }
        });
        this.batchSelectManager = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9() {
        Integer num;
        LiveData<BatchManageOperate> i3;
        BatchManageOperate value;
        LiveData<BatchManageOperate> i16;
        BatchManageOperate value2;
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        String str = null;
        if (fVar != null && (i16 = fVar.i()) != null && (value2 = i16.getValue()) != null) {
            num = value2.getSelectCount();
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        vi1.f fVar2 = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar2 != null && (i3 = fVar2.i()) != null && (value = i3.getValue()) != null) {
            str = value.getSelectedDesc();
        }
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u4f60\u5df2\u9009\u4e2d" + str + "\u7bc7\u5e16\u5b50\uff0c\u662f\u5426\u9000\u51fa\uff1f", getContext().getString(R.string.cancel), "\u9000\u51fa", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i17) {
                GuildFeedBatchManageTitlePart.F9(GuildFeedBatchManageTitlePart.this, dialogInterface, i17);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i17) {
                GuildFeedBatchManageTitlePart.G9(dialogInterface, i17);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(GuildFeedBatchManageTitlePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final a H9() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(View containerView) {
        Map<String, ? extends Object> emptyMap;
        RFWIocAbilityProvider.g().getIoc(vi1.d.class).originView(containerView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.x
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                GuildFeedBatchManageTitlePart.J9((vi1.d) obj);
            }
        }).run();
        yl1.b bVar = yl1.b.f450589a;
        emptyMap = MapsKt__MapsKt.emptyMap();
        bVar.e(containerView, "em_sgrp_search_box", emptyMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(vi1.d dVar) {
        dVar.I0(true);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void K9() {
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.navBar;
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = null;
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon = null;
        }
        View findViewById = guildDefaultThemeNavBarCommon.findViewById(R.id.ivTitleName);
        if (findViewById != null) {
            findViewById.setClickable(false);
            findViewById.setLongClickable(false);
        }
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon3 = this.navBar;
        if (guildDefaultThemeNavBarCommon3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon3 = null;
        }
        View findViewById2 = guildDefaultThemeNavBarCommon3.findViewById(R.id.jp7);
        if (findViewById2 != null) {
            findViewById2.setClickable(false);
            findViewById2.setLongClickable(false);
        }
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon4 = this.navBar;
        if (guildDefaultThemeNavBarCommon4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
        } else {
            guildDefaultThemeNavBarCommon2 = guildDefaultThemeNavBarCommon4;
        }
        guildDefaultThemeNavBarCommon2.setOnTouchListener(new b(this));
    }

    private final void L9() {
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.navBar;
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon = null;
        }
        guildDefaultThemeNavBarCommon.setOnItemSelectListener(H9());
        K9();
    }

    private final void M9() {
        Serializable serializable;
        Bundle arguments;
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = null;
        if (bVar != null && (arguments = bVar.getArguments()) != null) {
            serializable = arguments.getSerializable("source");
        } else {
            serializable = null;
        }
        if (Intrinsics.areEqual(serializable, "source_from_feed_square")) {
            GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = this.navBar;
            if (guildDefaultThemeNavBarCommon2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navBar");
                guildDefaultThemeNavBarCommon2 = null;
            }
            guildDefaultThemeNavBarCommon2.setLeftText(R.string.f140850f3);
            GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon3 = this.navBar;
            if (guildDefaultThemeNavBarCommon3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navBar");
                guildDefaultThemeNavBarCommon3 = null;
            }
            TextView g16 = guildDefaultThemeNavBarCommon3.g();
            if (g16 != null) {
                g16.setGravity(8388627);
            }
        }
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon4 = this.navBar;
        if (guildDefaultThemeNavBarCommon4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon4 = null;
        }
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon5 = this.navBar;
        if (guildDefaultThemeNavBarCommon5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon5 = null;
        }
        guildDefaultThemeNavBarCommon4.setTitle(guildDefaultThemeNavBarCommon5.getContext().getString(R.string.f1489010u));
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon6 = this.navBar;
        if (guildDefaultThemeNavBarCommon6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
        } else {
            guildDefaultThemeNavBarCommon = guildDefaultThemeNavBarCommon6;
        }
        guildDefaultThemeNavBarCommon.setRightDrawable(R.drawable.guild_search_new);
    }

    @Override // co1.g
    @Nullable
    public View O0() {
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.navBar;
        if (guildDefaultThemeNavBarCommon == null) {
            return null;
        }
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon = null;
        }
        return guildDefaultThemeNavBarCommon;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        Boolean bool;
        vi1.d dVar = (vi1.d) PartIOCKt.getIocInterface(this, vi1.d.class);
        if (dVar != null) {
            bool = Boolean.valueOf(dVar.getIsInSearchMode());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return super.onBackEvent();
        }
        E9();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.rlCommenTitle);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rlCommenTitle)");
        this.navBar = (GuildDefaultThemeNavBarCommon) findViewById;
        M9();
        L9();
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.navBar;
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            guildDefaultThemeNavBarCommon = null;
        }
        guildDefaultThemeNavBarCommon.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(DialogInterface dialogInterface, int i3) {
    }
}
