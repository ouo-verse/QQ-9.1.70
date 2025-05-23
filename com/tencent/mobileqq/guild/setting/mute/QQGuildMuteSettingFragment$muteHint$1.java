package com.tencent.mobileqq.guild.setting.mute;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.widget.listitem.v;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/QQGuildMuteSettingFragment$muteHint$1", "Lcom/tencent/mobileqq/widget/listitem/v;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildMuteSettingFragment$muteHint$1 extends v {

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ QQGuildMuteSettingFragment f234813l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGuildMuteSettingFragment$muteHint$1(QQGuildMuteSettingFragment qQGuildMuteSettingFragment, int i3) {
        super(i3);
        this.f234813l = qQGuildMuteSettingFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.v, com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public View H(@NotNull ViewGroup parent) {
        e12.a ci5;
        Intrinsics.checkNotNullParameter(parent, "parent");
        View H = super.H(parent);
        View findViewById = H.findViewById(R.id.wrt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.g\u2026d_mute_setting_hint_text)");
        final TextView textView = (TextView) findViewById;
        ci5 = this.f234813l.ci();
        LifecycleOwner viewLifecycleOwner = this.f234813l.getViewLifecycleOwner();
        final QQGuildMuteSettingFragment qQGuildMuteSettingFragment = this.f234813l;
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.guild.setting.mute.QQGuildMuteSettingFragment$muteHint$1$onCreateView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                String str;
                boolean hi5;
                Logger logger = Logger.f235387a;
                QQGuildMuteSettingFragment qQGuildMuteSettingFragment2 = qQGuildMuteSettingFragment;
                Logger.a d16 = logger.d();
                str = qQGuildMuteSettingFragment2.mTinyId;
                d16.i("Q_G_MUTE.QQGuildMuteSettingFragm", 1, "mGuildMuteObserver time:" + l3 + " id:" + str);
                if (c.O(l3)) {
                    TextView textView2 = textView;
                    hi5 = qQGuildMuteSettingFragment.hi();
                    textView2.setText(c.x(hi5, l3));
                }
            }
        };
        ci5.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.mute.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildMuteSettingFragment$muteHint$1.K(Function1.this, obj);
            }
        });
        return H;
    }
}
