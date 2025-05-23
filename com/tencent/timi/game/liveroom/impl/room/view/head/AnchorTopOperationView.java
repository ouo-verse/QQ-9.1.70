package com.tencent.timi.game.liveroom.impl.room.view.head;

import af4.OperationData;
import af4.OperationItem;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ug4.a;
import vn4.TimiPicInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0018\u0018\u0000 -2\u00020\u0001:\u0001.B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\b\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0002R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006/"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopOperationView;", "Landroid/widget/FrameLayout;", "", "b", "Landroid/widget/ImageView;", "igv", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "c", "", VirtualAppProxy.KEY_GAME_ID, "", "roomId", "d", "e", "Laf4/c;", "data", "setData", "f", "Lnr2/n;", "Lnr2/n;", "binding", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/drawable/ColorDrawable;", "defaultColorDrawable", "com/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopOperationView$b", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopOperationView$b;", "configUpdateListener", tl.h.F, "J", "i", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Laf4/c;", "mData", "", BdhLogUtil.LogTag.Tag_Conn, "Z", MiniChatConstants.MINI_APP_LANDSCAPE, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorTopOperationView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nr2.n binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorDrawable defaultColorDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b configUpdateListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int gameId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OperationData mData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopOperationView$b", "Lcom/tencent/timi/game/liveroom/impl/room/view/config/BusConfigHelper$a;", "", "roomId", "Luq4/c;", DownloadInfo.spKey_Config, "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements BusConfigHelper.a {
        b() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper.a
        public void a(long roomId, @Nullable uq4.c config) {
            AnchorTopOperationView.this.f();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopOperationView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        String str;
        OperationItem operationItem;
        List<OperationItem> i3;
        Object firstOrNull;
        HashMap hashMap = new HashMap();
        if (this.isLandscape) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("qqlive_screen_orientation", str);
        OperationData operationData = this.mData;
        if (operationData != null && (i3 = operationData.i()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) i3);
            operationItem = (OperationItem) firstOrNull;
        } else {
            operationItem = null;
        }
        if (operationItem != null) {
            hashMap.put("qqlive_resource_id", String.valueOf(operationItem.getIAdId()));
        }
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.a((ug4.a) b16, this, false, null, "em_qqlive_operation", hashMap, 6, null);
    }

    private final URLDrawable.URLDrawableOptions c(ImageView igv) {
        Drawable drawable;
        Drawable drawable2;
        URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
        if (igv.getDrawable() != null) {
            drawable = igv.getDrawable();
        } else {
            drawable = this.defaultColorDrawable;
        }
        options.mLoadingDrawable = drawable;
        if (igv.getDrawable() != null) {
            drawable2 = igv.getDrawable();
        } else {
            drawable2 = this.defaultColorDrawable;
        }
        options.mFailedDrawable = drawable2;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(OperationItem this_run, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        com.tencent.timi.game.ad.ui.d.f376246a.b(this_run);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void d(int gameId, long roomId) {
        this.gameId = gameId;
        this.roomId = roomId;
        BusConfigHelper.f378723a.h(roomId, this.configUpdateListener);
    }

    public final void e() {
        BusConfigHelper.f378723a.r(this.roomId, this.configUpdateListener);
    }

    public final void f() {
        final OperationItem operationItem;
        boolean z16;
        List<OperationItem> i3;
        Object firstOrNull;
        OperationData operationData = this.mData;
        if (operationData != null && (i3 = operationData.i()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) i3);
            operationItem = (OperationItem) firstOrNull;
        } else {
            operationItem = null;
        }
        int i16 = 8;
        if (operationItem != null) {
            if (operationItem.getPic().getUrl().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !BusConfigHelper.f378723a.f(2, this.roomId)) {
                if (af4.g.f26031a.e(this.roomId, this.gameId, operationItem, OperationItem.INSTANCE.a())) {
                    i16 = 0;
                }
            }
        }
        setVisibility(i16);
        if (operationItem != null) {
            RoundCornerImageView roundCornerImageView = this.binding.f421097b;
            Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.operationIcon");
            TimiPicInfo pic = operationItem.getPic();
            RoundCornerImageView roundCornerImageView2 = this.binding.f421097b;
            Intrinsics.checkNotNullExpressionValue(roundCornerImageView2, "binding.operationIcon");
            com.tencent.timi.game.utils.b.f(roundCornerImageView, pic, c(roundCornerImageView2));
            setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnchorTopOperationView.g(OperationItem.this, view);
                }
            });
        }
    }

    public final void setData(@NotNull OperationData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        b();
        f();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopOperationView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnchorTopOperationView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopOperationView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        nr2.n f16 = nr2.n.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.defaultColorDrawable = new ColorDrawable(Color.parseColor("#01010000"));
        f16.f421097b.setRadius(com.tencent.timi.game.utils.b.c(11));
        this.configUpdateListener = new b();
    }
}
