package com.tencent.mobileqq.guild.setting.mute;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.VerticalGallery;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u00020\u0001:\u0005567\u0017\u001bB'\b\u0007\u0012\u0006\u0010.\u001a\u00020\u0016\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010 \u001a\f\u0012\b\u0012\u00060\u001eR\u00020\u00000\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteWheelView;", "view", "", "column", "", "l", "Landroid/view/View;", "textView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mode", "p", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$e;", "adapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "row", "setSelection", "o", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$c;", "listener", "setSelectedListener", "Landroid/content/Context;", "d", "Landroid/content/Context;", "mContext", "", "e", "Ljava/util/List;", "mWheelViews", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$d;", "f", "mInnerAdapters", tl.h.F, "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$e;", "mAdapter", "i", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$c;", "mSelectListener", "Lcom/tencent/widget/AdapterView$OnItemSelectedListener;", "Lcom/tencent/widget/AdapterView$OnItemSelectedListener;", "mItemSelectedListener", "Lcom/tencent/widget/VerticalGallery$OnSelectViewDataUpdateListener;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/widget/VerticalGallery$OnSelectViewDataUpdateListener;", "mDataUpdateListener", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMuteCustomTimePickView extends LinearLayout {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int E = Color.parseColor("#000000");
    private static final int F = Color.parseColor("#4DE8E9EA");
    private static final int G = Color.parseColor("#FF222222");
    private static final int H = Color.parseColor("#E8E9EA");

    @NotNull
    private static final String[] I = {"\u5929", "\u5c0f\u65f6", "\u5206\u949f"};

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final VerticalGallery.OnSelectViewDataUpdateListener mDataUpdateListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<GuildMuteWheelView> mWheelViews;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<d> mInnerAdapters;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private e mAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mSelectListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AdapterView.OnItemSelectedListener mItemSelectedListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$a;", "", "", "DEFAULT_TEXT_COLOR", "I", "a", "()I", "DEFAULT_TEXT_COLOR_NIGHT", "b", "SELECT_TEXT_COLOR", "c", "SELECT_TEXT_COLOR_NIGHT", "d", "", "DEFAULT_TEXT_SIZE", UserInfo.SEX_FEMALE, "LINE_HEIGHT_DP", "MODE_DEFAULT", "MODE_SELECTED", "SELECT_TEXT_SIZE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.mute.GuildMuteCustomTimePickView$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GuildMuteCustomTimePickView.E;
        }

        public final int b() {
            return GuildMuteCustomTimePickView.F;
        }

        public final int c() {
            return GuildMuteCustomTimePickView.G;
        }

        public final int d() {
            return GuildMuteCustomTimePickView.H;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$b;", "Lcom/tencent/widget/VerticalGallery$OnEndMovementListener;", "Lcom/tencent/widget/VerticalGallery;", "v", "", "onEndMovement", "", "d", "I", "column", "<init>", "(Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class b implements VerticalGallery.OnEndMovementListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int column;

        public b(int i3) {
            this.column = i3;
        }

        @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
        public void onEndMovement(@NotNull VerticalGallery v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            List list = GuildMuteCustomTimePickView.this.mWheelViews;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWheelViews");
                list = null;
            }
            int selectedItemPosition = ((WheelView) list.get(this.column)).getSelectedItemPosition();
            c cVar = GuildMuteCustomTimePickView.this.mSelectListener;
            if (cVar != null) {
                cVar.onItemSelected(this.column, selectedItemPosition);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$c;", "", "", "column", "row", "", "onItemSelected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface c {
        void onItemSelected(int column, int row);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$d;", "Landroid/widget/BaseAdapter;", "", "getCount", "position", "", "getItem", "", "getItemId", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "d", "I", "mColumn", "<init>", "(Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class d extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int mColumn;

        public d(int i3) {
            this.mColumn = i3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            e eVar = GuildMuteCustomTimePickView.this.mAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                eVar = null;
            }
            return eVar.getRowCount(this.mColumn);
        }

        @Override // android.widget.Adapter
        @NotNull
        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        @NotNull
        public View getView(int position, @Nullable View view, @NotNull ViewGroup parent) {
            View view2;
            int a16;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (view == null) {
                view2 = new WheelTextView(GuildMuteCustomTimePickView.this.mContext);
                view2.setLayoutParams(new VerticalGallery.LayoutParams(-1, ViewUtils.dpToPx(50.0f)));
                view2.setFocusable(true);
                view2.setPadding(0, 0, ViewUtils.dpToPx(16.666666f) * 2, 0);
                view2.setFocusableInTouchMode(true);
            } else {
                view2 = view;
            }
            e eVar = GuildMuteCustomTimePickView.this.mAdapter;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                eVar = null;
            }
            String text = eVar.getText(this.mColumn, position);
            WheelTextView wheelTextView = (WheelTextView) view2;
            wheelTextView.setTextSize(2, 17.0f);
            if (GuildThemeManager.f235286a.b()) {
                a16 = GuildMuteCustomTimePickView.INSTANCE.b();
            } else {
                a16 = GuildMuteCustomTimePickView.INSTANCE.a();
            }
            wheelTextView.setTextColor(a16);
            wheelTextView.setGravity(17);
            wheelTextView.setSingleLine();
            wheelTextView.setMinEms(3);
            wheelTextView.setText(text);
            EventCollector.getInstance().onListGetView(position, view, parent, getItemId(position));
            return view2;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$e;", "", "", "column", "getRowCount", "row", "", "getText", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface e {
        int getRowCount(int column);

        @Nullable
        String getText(int column, int row);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMuteCustomTimePickView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l(GuildMuteWheelView view, int column) {
        view.setTag(Integer.valueOf(column));
        view.setExtraText(I[column]);
        d dVar = new d(column);
        List<GuildMuteWheelView> list = this.mWheelViews;
        List<d> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWheelViews");
            list = null;
        }
        list.add(view);
        List<d> list3 = this.mInnerAdapters;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInnerAdapters");
        } else {
            list2 = list3;
        }
        list2.add(dVar);
        view.setAdapter((SpinnerAdapter) dVar);
        view.setOnItemSelectedListener(this.mItemSelectedListener);
        view.setOnSelectViewDataUpdateListener(this.mDataUpdateListener);
        view.setOnEndMovementListener(new b(column));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GuildMuteCustomTimePickView this$0, View child, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(child, "child");
        this$0.p(child, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(View textView, int mode) {
        int i3;
        int i16;
        if (!(textView instanceof WheelTextView)) {
            return;
        }
        Intrinsics.checkNotNull(textView, "null cannot be cast to non-null type com.tencent.mobileqq.remind.widget.WheelTextView");
        WheelTextView wheelTextView = (WheelTextView) textView;
        boolean b16 = GuildThemeManager.f235286a.b();
        if (mode == 0) {
            wheelTextView.setTextSize(17.0f);
            if (b16) {
                i16 = F;
            } else {
                i16 = E;
            }
            wheelTextView.setTextColor(i16);
            return;
        }
        wheelTextView.setTextSize(17.0f);
        if (b16) {
            i3 = H;
        } else {
            i3 = G;
        }
        wheelTextView.setTextColor(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(View textView) {
        if (textView instanceof WheelTextView) {
            WheelTextView wheelTextView = (WheelTextView) textView;
            wheelTextView.setContentDescription(wheelTextView.getText());
        }
    }

    public final void m(@NotNull e adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.mAdapter = adapter;
        this.mWheelViews = new ArrayList();
        this.mInnerAdapters = new ArrayList();
        removeAllViewsInLayout();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.f0l, (ViewGroup) null);
        addView(inflate, new LinearLayout.LayoutParams(-1, -1));
        int[] iArr = {R.id.x57, R.id.x58, R.id.x59};
        for (int i3 = 0; i3 < 3; i3++) {
            View findViewById = inflate.findViewById(iArr[i3]);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(ids[i])");
            l((GuildMuteWheelView) findViewById, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int column) {
        boolean z16;
        List<d> list = null;
        if (column >= 0) {
            List<d> list2 = this.mInnerAdapters;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInnerAdapters");
                list2 = null;
            }
            if (column < list2.size()) {
                z16 = true;
                if (!z16) {
                    List<d> list3 = this.mInnerAdapters;
                    if (list3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInnerAdapters");
                    } else {
                        list = list3;
                    }
                    list.get(column).notifyDataSetChanged();
                    return;
                }
                throw new IllegalArgumentException(("Error column index " + column).toString());
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    public final void setSelectedListener(@Nullable c listener) {
        this.mSelectListener = listener;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setSelection(int column, int row) {
        boolean z16;
        List<GuildMuteWheelView> list = null;
        if (column >= 0) {
            List<GuildMuteWheelView> list2 = this.mWheelViews;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWheelViews");
                list2 = null;
            }
            if (column < list2.size()) {
                z16 = true;
                if (!z16) {
                    List<GuildMuteWheelView> list3 = this.mWheelViews;
                    if (list3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mWheelViews");
                    } else {
                        list = list3;
                    }
                    list.get(column).setSelection(row, true);
                    return;
                }
                throw new IllegalArgumentException(("Error column index " + column).toString());
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMuteCustomTimePickView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildMuteCustomTimePickView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMuteCustomTimePickView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        setOrientation(1);
        this.mItemSelectedListener = new f();
        this.mDataUpdateListener = new VerticalGallery.OnSelectViewDataUpdateListener() { // from class: com.tencent.mobileqq.guild.setting.mute.d
            @Override // com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener
            public final void onSelectDataUpdate(View view, int i16) {
                GuildMuteCustomTimePickView.n(GuildMuteCustomTimePickView.this, view, i16);
            }
        };
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$f", "Lcom/tencent/widget/AdapterView$OnItemSelectedListener;", "Lcom/tencent/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements AdapterView.OnItemSelectedListener {
        f() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@NotNull AdapterView<?> parent, @NotNull View view, int position, long id5) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(view, "view");
            GuildMuteCustomTimePickView.this.p(view, 1);
            GuildMuteCustomTimePickView.this.q(view);
            if (view.getTag() == null) {
                return;
            }
            int parseInt = Integer.parseInt(view.getTag().toString());
            int childCount = parent.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (parseInt != i3) {
                    GuildMuteCustomTimePickView guildMuteCustomTimePickView = GuildMuteCustomTimePickView.this;
                    View childAt = parent.getChildAt(i3);
                    Intrinsics.checkNotNullExpressionValue(childAt, "parent.getChildAt(i)");
                    guildMuteCustomTimePickView.p(childAt, 0);
                    GuildMuteCustomTimePickView guildMuteCustomTimePickView2 = GuildMuteCustomTimePickView.this;
                    View childAt2 = parent.getChildAt(i3);
                    Intrinsics.checkNotNullExpressionValue(childAt2, "parent.getChildAt(i)");
                    guildMuteCustomTimePickView2.q(childAt2);
                }
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@Nullable AdapterView<?> parent) {
        }
    }
}
