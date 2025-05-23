package com.tencent.mobileqq.troop.flame.detail.part;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/data/a;", "kotlin.jvm.PlatformType", "data", "", "invoke", "(Lcom/tencent/mobileqq/troop/flame/detail/data/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopFlameContentPart$observerData$1 extends Lambda implements Function1<com.tencent.mobileqq.troop.flame.detail.data.a, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopFlameContentPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFlameContentPart$observerData$1(TroopFlameContentPart troopFlameContentPart) {
        super(1);
        this.this$0 = troopFlameContentPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopFlameContentPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.mobileqq.troop.flame.detail.data.a aVar, TroopFlameContentPart this$0, View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aVar.c() != 0 || aVar.e() != 0) {
            if (aVar.c() != 0) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            String str = "https://h5.qun.qq.com/h5/qun-fire/?_wv=16777219&_wwv=5&&groupCode=" + this$0.V9() + "&tab=" + i3;
            Intent intent = new Intent(this$0.getContext(), (Class<?>) QQBrowserActivity.class);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("url", str);
                this$0.getContext().startActivity(intent);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.flame.detail.data.a aVar) {
        invoke2(aVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final com.tencent.mobileqq.troop.flame.detail.data.a aVar) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        ImageView imageView;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        ViewGroup viewGroup3;
        ViewGroup viewGroup4;
        TextView textView11;
        TextView textView12;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        textView = this.this$0.activeDays;
        ViewGroup viewGroup5 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeDays");
            textView = null;
        }
        textView.setText(String.valueOf(aVar.a()));
        textView2 = this.this$0.activeMembers;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeMembers");
            textView2 = null;
        }
        textView2.setText(String.valueOf(aVar.b()));
        if (aVar.c() != 0) {
            textView11 = this.this$0.troopRankHint;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopRankHint");
                textView11 = null;
            }
            textView11.setText(HardCodeUtil.qqStr(R.string.f2330776_));
            textView12 = this.this$0.troopRank;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopRank");
                textView12 = null;
            }
            textView12.setText(String.valueOf(aVar.c()));
        } else if (aVar.e() != 0) {
            textView5 = this.this$0.troopRankHint;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopRankHint");
                textView5 = null;
            }
            textView5.setText(HardCodeUtil.qqStr(R.string.f23306769));
            textView6 = this.this$0.troopRank;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopRank");
                textView6 = null;
            }
            textView6.setText(String.valueOf(aVar.e()));
        } else {
            textView3 = this.this$0.troopRankHint;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopRankHint");
                textView3 = null;
            }
            textView3.setText(HardCodeUtil.qqStr(R.string.f2330976b));
            imageView = this.this$0.troopRankHintIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopRankHintIcon");
                imageView = null;
            }
            imageView.setVisibility(8);
            textView4 = this.this$0.troopRankHintUnit;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopRankHintUnit");
                textView4 = null;
            }
            textView4.setText(HardCodeUtil.qqStr(R.string.f2331076c));
        }
        viewGroup = this.this$0.troopRankViewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopRankViewGroup");
            viewGroup2 = null;
        } else {
            viewGroup2 = viewGroup;
        }
        final TroopFlameContentPart troopFlameContentPart = this.this$0;
        TriggerRunnerKt.c(viewGroup2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.flame.detail.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopFlameContentPart$observerData$1.b(com.tencent.mobileqq.troop.flame.detail.data.a.this, troopFlameContentPart, view);
            }
        }, 1, null);
        textView7 = this.this$0.ruleDetail;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ruleDetail");
            textView7 = null;
        }
        textView7.setText(aVar.d().a());
        textView8 = this.this$0.minFlameRule;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minFlameRule");
            textView8 = null;
        }
        textView8.setText(aVar.d().b());
        textView9 = this.this$0.midFlameRule;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("midFlameRule");
            textView9 = null;
        }
        textView9.setText(aVar.d().c());
        textView10 = this.this$0.maxFlameRule;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maxFlameRule");
            textView10 = null;
        }
        textView10.setText(aVar.d().d());
        viewGroup3 = this.this$0.rankInfoViewGroup;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankInfoViewGroup");
            viewGroup3 = null;
        }
        viewGroup3.setVisibility(0);
        viewGroup4 = this.this$0.ruleViewGroup;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ruleViewGroup");
        } else {
            viewGroup5 = viewGroup4;
        }
        viewGroup5.setVisibility(0);
    }
}
