package com.tencent.mobileqq.guild.setting.mute;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.setting.mute.GuildMuteCustomTimePickView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002EFB\u001b\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\b\b\u0002\u0010A\u001a\u00020\u0006\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010\u001bR\u0016\u0010-\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010\u001bR\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/e;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "", "initWindow", "W", "", ReportConstant.COSTREPORT_PREFIX, "e", "", "X", "initView", "Z", "day", WidgetCacheWeatherData.HOUR, "minute", "Y", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/tencent/mobileqq/guild/setting/mute/e$b;", "listener", "a0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "D", "mTopBgView", "E", "Ljava/util/List;", "mDayDataList", UserInfo.SEX_FEMALE, "mHourDataList", "G", "mMinuteDataList", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView;", "H", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView;", "mTimePickerView", "I", "mCancelView", "J", "mConfirmView", "K", "mDayIndex", "L", "mHourIndex", "M", "mMinuteIndex", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$e;", "N", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$e;", "mMuteTimeAdapter", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$c;", "P", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$c;", "mPickListener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/setting/mute/e$b;", "mConfirmListener", "Landroid/content/Context;", "context", "themeResId", "<init>", "(Landroid/content/Context;I)V", BdhLogUtil.LogTag.Tag_Req, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends ReportDialog implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private View mTopBgView;

    /* renamed from: E, reason: from kotlin metadata */
    private List<Integer> mDayDataList;

    /* renamed from: F, reason: from kotlin metadata */
    private List<Integer> mHourDataList;

    /* renamed from: G, reason: from kotlin metadata */
    private List<Integer> mMinuteDataList;

    /* renamed from: H, reason: from kotlin metadata */
    private GuildMuteCustomTimePickView mTimePickerView;

    /* renamed from: I, reason: from kotlin metadata */
    private View mCancelView;

    /* renamed from: J, reason: from kotlin metadata */
    private View mConfirmView;

    /* renamed from: K, reason: from kotlin metadata */
    private int mDayIndex;

    /* renamed from: L, reason: from kotlin metadata */
    private int mHourIndex;

    /* renamed from: M, reason: from kotlin metadata */
    private int mMinuteIndex;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final GuildMuteCustomTimePickView.e mMuteTimeAdapter;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final GuildMuteCustomTimePickView.c mPickListener;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private b mConfirmListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/e$b;", "", "", "day", WidgetCacheWeatherData.HOUR, "minute", "", "onConfirm", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void onConfirm(int day, int hour, int minute);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/e$c", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$e;", "", "column", "getRowCount", "row", "", "getText", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements GuildMuteCustomTimePickView.e {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.setting.mute.GuildMuteCustomTimePickView.e
        public int getRowCount(int column) {
            if (column != 0) {
                if (column != 1) {
                    return 60;
                }
                return 24;
            }
            return 30;
        }

        @Override // com.tencent.mobileqq.guild.setting.mute.GuildMuteCustomTimePickView.e
        @NotNull
        public String getText(int column, int row) {
            if (column == 0) {
                row += 0;
            }
            return String.valueOf(row);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/e$d", "Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteCustomTimePickView$c;", "", "column", "row", "", "onItemSelected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements GuildMuteCustomTimePickView.c {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.setting.mute.GuildMuteCustomTimePickView.c
        public void onItemSelected(int column, int row) {
            if (column == 0) {
                e.this.mDayIndex = row;
            } else if (column != 1) {
                e.this.mMinuteIndex = row;
            } else {
                e.this.mHourIndex = row;
            }
            if (e.this.mDayIndex == 0 && e.this.mHourIndex == 0 && e.this.mMinuteIndex == 0) {
                e.this.mMinuteIndex = 1;
                GuildMuteCustomTimePickView guildMuteCustomTimePickView = e.this.mTimePickerView;
                GuildMuteCustomTimePickView guildMuteCustomTimePickView2 = null;
                if (guildMuteCustomTimePickView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimePickerView");
                    guildMuteCustomTimePickView = null;
                }
                guildMuteCustomTimePickView.setSelection(2, e.this.mMinuteIndex);
                GuildMuteCustomTimePickView guildMuteCustomTimePickView3 = e.this.mTimePickerView;
                if (guildMuteCustomTimePickView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTimePickerView");
                } else {
                    guildMuteCustomTimePickView2 = guildMuteCustomTimePickView3;
                }
                guildMuteCustomTimePickView2.o(2);
            }
        }
    }

    public /* synthetic */ e(Context context, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? R.style.axd : i3);
    }

    private final void W() {
        this.mDayDataList = X(0, 29);
        this.mHourDataList = X(0, 23);
        this.mMinuteDataList = X(0, 59);
    }

    private final List<Integer> X(int s16, int e16) {
        ArrayList arrayList = new ArrayList();
        if (s16 <= e16) {
            while (true) {
                arrayList.add(Integer.valueOf(s16));
                if (s16 == e16) {
                    break;
                }
                s16++;
            }
        }
        return arrayList;
    }

    private final void Z() {
        GuildMuteCustomTimePickView guildMuteCustomTimePickView = this.mTimePickerView;
        GuildMuteCustomTimePickView guildMuteCustomTimePickView2 = null;
        if (guildMuteCustomTimePickView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimePickerView");
            guildMuteCustomTimePickView = null;
        }
        guildMuteCustomTimePickView.setSelection(0, this.mDayIndex);
        GuildMuteCustomTimePickView guildMuteCustomTimePickView3 = this.mTimePickerView;
        if (guildMuteCustomTimePickView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimePickerView");
            guildMuteCustomTimePickView3 = null;
        }
        guildMuteCustomTimePickView3.setSelection(1, this.mHourIndex);
        GuildMuteCustomTimePickView guildMuteCustomTimePickView4 = this.mTimePickerView;
        if (guildMuteCustomTimePickView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimePickerView");
            guildMuteCustomTimePickView4 = null;
        }
        guildMuteCustomTimePickView4.setSelection(2, this.mMinuteIndex);
        GuildMuteCustomTimePickView guildMuteCustomTimePickView5 = this.mTimePickerView;
        if (guildMuteCustomTimePickView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimePickerView");
            guildMuteCustomTimePickView5 = null;
        }
        guildMuteCustomTimePickView5.o(0);
        GuildMuteCustomTimePickView guildMuteCustomTimePickView6 = this.mTimePickerView;
        if (guildMuteCustomTimePickView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimePickerView");
            guildMuteCustomTimePickView6 = null;
        }
        guildMuteCustomTimePickView6.o(1);
        GuildMuteCustomTimePickView guildMuteCustomTimePickView7 = this.mTimePickerView;
        if (guildMuteCustomTimePickView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimePickerView");
        } else {
            guildMuteCustomTimePickView2 = guildMuteCustomTimePickView7;
        }
        guildMuteCustomTimePickView2.o(2);
    }

    private final void initView() {
        View view = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f0k, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026tom_setting_dialog, null)");
        this.mRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        super.setContentView(inflate);
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById = view2.findViewById(R.id.wru);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026d.guild_mute_time_picker)");
        GuildMuteCustomTimePickView guildMuteCustomTimePickView = (GuildMuteCustomTimePickView) findViewById;
        this.mTimePickerView = guildMuteCustomTimePickView;
        if (guildMuteCustomTimePickView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimePickerView");
            guildMuteCustomTimePickView = null;
        }
        guildMuteCustomTimePickView.m(this.mMuteTimeAdapter);
        GuildMuteCustomTimePickView guildMuteCustomTimePickView2 = this.mTimePickerView;
        if (guildMuteCustomTimePickView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimePickerView");
            guildMuteCustomTimePickView2 = null;
        }
        guildMuteCustomTimePickView2.setSelectedListener(this.mPickListener);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.wrq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026te_custom_time_pick_root)");
        this.mTopBgView = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopBgView");
            findViewById2 = null;
        }
        findViewById2.setOnClickListener(this);
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById3 = view4.findViewById(R.id.wro);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026tom_setting_root_confirm)");
        this.mConfirmView = findViewById3;
        if (findViewById3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirmView");
            findViewById3 = null;
        }
        findViewById3.setOnClickListener(this);
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        View findViewById4 = view5.findViewById(R.id.wrn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R\u2026stom_setting_root_cancel)");
        this.mCancelView = findViewById4;
        if (findViewById4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCancelView");
        } else {
            view = findViewById4;
        }
        view.setOnClickListener(this);
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("Q_G_MUTE.QQGuildMuteCustomSettin", 1, e16, new Object[0]);
        }
        window.setWindowAnimations(R.style.f173293c);
    }

    public final void Y(int day, int hour, int minute) {
        this.mDayIndex = day;
        this.mHourIndex = hour;
        this.mMinuteIndex = minute;
        if (this.mTimePickerView != null) {
            Z();
        }
    }

    public final void a0(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mConfirmListener = listener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View] */
    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        View view = this.mTopBgView;
        List<Integer> list = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopBgView");
            view = null;
        }
        if (Intrinsics.areEqual(v3, view)) {
            dismiss();
        } else {
            View view2 = this.mConfirmView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConfirmView");
                view2 = null;
            }
            if (Intrinsics.areEqual(v3, view2)) {
                b bVar = this.mConfirmListener;
                if (bVar != null) {
                    List<Integer> list2 = this.mDayDataList;
                    if (list2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDayDataList");
                        list2 = null;
                    }
                    int intValue = list2.get(this.mDayIndex).intValue();
                    List<Integer> list3 = this.mHourDataList;
                    if (list3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHourDataList");
                        list3 = null;
                    }
                    int intValue2 = list3.get(this.mHourIndex).intValue();
                    List<Integer> list4 = this.mMinuteDataList;
                    if (list4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMinuteDataList");
                    } else {
                        list = list4;
                    }
                    bVar.onConfirm(intValue, intValue2, list.get(this.mMinuteIndex).intValue());
                }
                dismiss();
            } else {
                ?? r06 = this.mCancelView;
                if (r06 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCancelView");
                } else {
                    list = r06;
                }
                if (Intrinsics.areEqual(v3, list)) {
                    dismiss();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        W();
        initView();
        Z();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public e(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMuteTimeAdapter = new c();
        this.mPickListener = new d();
    }
}
