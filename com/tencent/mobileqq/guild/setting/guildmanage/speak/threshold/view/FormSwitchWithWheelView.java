package com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.managepage.d;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Switch;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sz1.JoinTimeItem;
import tl.h;
import vp1.aw;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001$B\u001d\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001c\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/view/FormSwitchWithWheelView;", "Landroid/widget/LinearLayout;", "", h.F, "i", "", "joinTime", "setJoinTime", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "setOnCheckedChangeListener", "Lcom/tencent/widget/AdapterView$OnItemSelectedListener;", "setOnItemSelectedListener", "Lcom/tencent/widget/Switch;", "f", "", "position", "e", "Lsz1/a;", "d", "l", "", "j", "g", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "Lvp1/aw;", "Lvp1/aw;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FormSwitchWithWheelView extends LinearLayout {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final List<JoinTimeItem> f234367f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final aw binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/view/FormSwitchWithWheelView$a;", "", "", "joinTime", "", "a", "", "Lsz1/a;", "timeList", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view.FormSwitchWithWheelView$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(long joinTime) {
            if (joinTime == JoinTimeType.THIRTY_MINUTES) {
                return b().indexOf(JoinTimeItem.INSTANCE.g());
            }
            if (joinTime == 3600) {
                return b().indexOf(JoinTimeItem.INSTANCE.a());
            }
            if (joinTime == JoinTimeType.THREE_HOUR) {
                return b().indexOf(JoinTimeItem.INSTANCE.i());
            }
            if (joinTime == JoinTimeType.SIX_HOUR) {
                return b().indexOf(JoinTimeItem.INSTANCE.f());
            }
            if (joinTime == 43200) {
                return b().indexOf(JoinTimeItem.INSTANCE.j());
            }
            if (joinTime == 86400) {
                return b().indexOf(JoinTimeItem.INSTANCE.d());
            }
            if (joinTime == 259200) {
                return b().indexOf(JoinTimeItem.INSTANCE.h());
            }
            if (joinTime == JoinTimeType.SEVEN_DAY) {
                return b().indexOf(JoinTimeItem.INSTANCE.e());
            }
            if (joinTime == JoinTimeType.FIFTEEN_DAY) {
                return b().indexOf(JoinTimeItem.INSTANCE.c());
            }
            return b().indexOf(JoinTimeItem.INSTANCE.g());
        }

        @NotNull
        public final List<JoinTimeItem> b() {
            return FormSwitchWithWheelView.f234367f;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/view/FormSwitchWithWheelView$b", "Lcom/tencent/widget/AdapterView$OnItemSelectedListener;", "Lcom/tencent/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements AdapterView.OnItemSelectedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AdapterView.OnItemSelectedListener f234369d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FormSwitchWithWheelView f234370e;

        b(AdapterView.OnItemSelectedListener onItemSelectedListener, FormSwitchWithWheelView formSwitchWithWheelView) {
            this.f234369d = onItemSelectedListener;
            this.f234370e = formSwitchWithWheelView;
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@Nullable AdapterView<?> parent, @Nullable View view, int position, long id5) {
            this.f234369d.onItemSelected(parent, view, position, id5);
            this.f234370e.binding.f442329b.setSubTitle(FormSwitchWithWheelView.INSTANCE.b().get(position).getDesc());
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@Nullable AdapterView<?> parent) {
            this.f234369d.onNothingSelected(parent);
        }
    }

    static {
        List<JoinTimeItem> mutableListOf;
        JoinTimeItem.Companion companion = JoinTimeItem.INSTANCE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(companion.g(), companion.a(), companion.i(), companion.f(), companion.j(), companion.d(), companion.h(), companion.e(), companion.c());
        f234367f = mutableListOf;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FormSwitchWithWheelView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void h() {
        this.binding.f442329b.getSwitch().setTrackResource(R.drawable.guild_switch_track_bg);
    }

    private final void i() {
        WheelView b16 = this.binding.f442330c.b();
        b16.setmMaxSkew(0.0f);
        b16.setmMaxRotationAngle(0);
        b16.setNeedTranslate(false);
        Context context = b16.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        d dVar = new d(context);
        b16.setAdapter((SpinnerAdapter) dVar);
        dVar.setData(f234367f);
        b16.setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(FormSwitchWithWheelView this$0, CompoundButton.OnCheckedChangeListener listener, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (z16) {
            this$0.binding.f442329b.setSubTitle(this$0.d().getDesc());
        } else {
            this$0.binding.f442329b.setSubTitle("");
        }
        listener.onCheckedChanged(compoundButton, z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @NotNull
    public final JoinTimeItem d() {
        Object selectedItem = this.binding.f442330c.b().getSelectedItem();
        Intrinsics.checkNotNull(selectedItem, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeItem");
        return (JoinTimeItem) selectedItem;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (action != 0) {
            if (action == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(ev5);
    }

    public final long e(int position) {
        return f234367f.get(position).getType();
    }

    @NotNull
    public final Switch f() {
        Switch r06 = this.binding.f442329b.getSwitch();
        Intrinsics.checkNotNullExpressionValue(r06, "binding.joinTimeChannelSwitch.switch");
        return r06;
    }

    public final void g() {
        this.binding.f442330c.setVisibility(8);
    }

    public final boolean j() {
        if (this.binding.f442330c.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void l() {
        this.binding.f442330c.setVisibility(0);
    }

    public final void setJoinTime(long joinTime) {
        if (joinTime == 0) {
            this.binding.f442329b.setChecked(false);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.sr.FormSwitchWithWheelView", 2, "set default join time");
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.sr.FormSwitchWithWheelView", 2, "set join time: " + joinTime);
        }
        this.binding.f442330c.b().setSelection(INSTANCE.a(joinTime));
        this.binding.f442329b.setSubTitle(d().getDesc());
        this.binding.f442329b.setChecked(true);
    }

    public final void setOnCheckedChangeListener(@NotNull final CompoundButton.OnCheckedChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.binding.f442329b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                FormSwitchWithWheelView.k(FormSwitchWithWheelView.this, listener, compoundButton, z16);
            }
        });
    }

    public final void setOnItemSelectedListener(@NotNull AdapterView.OnItemSelectedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.binding.f442330c.b().setOnItemSelectedListener(new b(listener, this));
    }

    public /* synthetic */ FormSwitchWithWheelView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FormSwitchWithWheelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(1);
        aw f16 = aw.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        h();
        i();
    }
}
