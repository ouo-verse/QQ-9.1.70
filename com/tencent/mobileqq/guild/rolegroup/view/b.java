package com.tencent.mobileqq.guild.rolegroup.view;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.selector.GuildEditPickerView;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u001dB\u0019\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/view/b;", "Lcom/tencent/mobileqq/guild/widget/selector/a;", "", "k", "i", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, h.F, "g", "e", "I", "mMinute", "f", "mSecond", "mMinuteIndex", "mSecondIndex", "Lcom/tencent/mobileqq/guild/widget/selector/GuildEditPickerView$e;", "Lcom/tencent/mobileqq/guild/widget/selector/GuildEditPickerView$e;", "mTimeAdapter", "Lcom/tencent/mobileqq/guild/widget/selector/GuildEditPickerView$f;", "j", "Lcom/tencent/mobileqq/guild/widget/selector/GuildEditPickerView$f;", "mListener", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isNightTheme", "<init>", "(Landroid/app/Activity;Z)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends com.tencent.mobileqq.guild.widget.selector.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mMinute;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mSecond;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mMinuteIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mSecondIndex;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildEditPickerView.e mTimeAdapter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildEditPickerView.f mListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/view/b$b", "Lcom/tencent/mobileqq/guild/widget/selector/GuildEditPickerView$e;", "", "getColumnCount", "column", "getRowCount", "row", "", "getText", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.view.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7886b implements GuildEditPickerView.e {
        C7886b() {
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildEditPickerView.e
        public int getColumnCount() {
            return 2;
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildEditPickerView.e
        public int getRowCount(int column) {
            if (column == 0) {
                return 61;
            }
            if (b.this.mMinuteIndex == 0) {
                return 50;
            }
            if (b.this.mMinuteIndex != 60) {
                return 60;
            }
            return 1;
        }

        @Override // com.tencent.mobileqq.guild.widget.selector.GuildEditPickerView.e
        @NotNull
        public String getText(int column, int row) {
            if (column == 0) {
                return row + QQGuildUIUtil.r(R.string.f1503114n);
            }
            String str = row + QQGuildUIUtil.r(R.string.f155581hw);
            if (b.this.mMinuteIndex == 0) {
                return (row + 10) + QQGuildUIUtil.r(R.string.f155581hw);
            }
            return str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Activity activity, boolean z16) {
        super(activity, z16);
        Intrinsics.checkNotNullParameter(activity, "activity");
        C7886b c7886b = new C7886b();
        this.mTimeAdapter = c7886b;
        GuildEditPickerView.f fVar = new GuildEditPickerView.f() { // from class: com.tencent.mobileqq.guild.rolegroup.view.a
            @Override // com.tencent.mobileqq.guild.widget.selector.GuildEditPickerView.f
            public final void onItemSelected(int i3, int i16) {
                b.j(b.this, i3, i16);
            }
        };
        this.mListener = fVar;
        this.f236605c.k(c7886b, z16);
        this.f236605c.setPickListener(fVar);
        c(QQGuildUIUtil.r(R.string.f140170d9));
    }

    private final void i() {
        this.f236605c.setSelection(0, this.mMinuteIndex);
        this.f236605c.l(0);
        this.f236605c.setSelection(1, this.mSecondIndex);
        this.f236605c.l(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(b this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int h16 = this$0.f236605c.h(0);
        int h17 = this$0.f236605c.h(1);
        if (h16 == 0 && h16 != this$0.mMinuteIndex) {
            int i17 = h17 - 10;
            this$0.mSecondIndex = i17;
            this$0.f236605c.setSelection(1, i17);
            this$0.mMinuteIndex = h16;
            this$0.f236605c.l(1);
        } else {
            int i18 = this$0.mMinuteIndex;
            if (i18 == 0 && h16 != i18) {
                int i19 = h17 + 10;
                this$0.mSecondIndex = i19;
                this$0.f236605c.setSelection(1, i19);
                this$0.mMinuteIndex = h16;
                this$0.f236605c.l(1);
            }
        }
        if (h16 != this$0.mMinuteIndex || h17 != this$0.mSecondIndex) {
            this$0.mSecondIndex = h17;
            this$0.mMinuteIndex = h16;
            this$0.f236605c.l(1);
        }
    }

    private final void k() {
        int i3 = this.mMinute;
        this.mMinuteIndex = i3;
        int i16 = this.mSecond;
        this.mSecondIndex = i16;
        if (i3 == 0) {
            this.mSecondIndex = i16 - 10;
        }
    }

    public final int g() {
        this.mMinuteIndex = this.f236605c.h(0);
        int h16 = this.f236605c.h(1);
        this.mSecondIndex = h16;
        int i3 = this.mMinuteIndex;
        this.mMinute = i3;
        if (i3 == 0) {
            this.mSecond = h16 + 10;
        } else {
            this.mSecond = h16;
        }
        return (i3 * 60) + this.mSecond;
    }

    public final void h(int second) {
        this.mMinute = second / 60;
        this.mSecond = second % 60;
        k();
        i();
    }
}
