package com.tencent.mobileqq.troop.troopidentity.parts;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtil;
import com.tencent.mobileqq.troop.troopidentity.view.c;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityAppTag;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityPreviewPart;", "Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityIconBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "P9", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", "appTag", "R9", "S9", "M9", "onInitView", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "e", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "nickNameTv", "Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", tl.h.F, "Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", "levelView", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "honorImageView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "appIconImageView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityPreviewPart extends TroopIdentityIconBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView avatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView nickNameTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TroopMemberNewLevelView levelView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView honorImageView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView appIconImageView;

    public TroopIdentityPreviewPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void M9() {
        LiveData<GetIdentityListRsp> Z1 = A9().Z1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<GetIdentityListRsp, Unit> function1 = new Function1<GetIdentityListRsp, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityPreviewPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityPreviewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GetIdentityListRsp getIdentityListRsp) {
                invoke2(getIdentityListRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GetIdentityListRsp getIdentityListRsp) {
                ImageView imageView;
                ImageView imageView2;
                ImageView imageView3;
                Integer intOrNull;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) getIdentityListRsp);
                    return;
                }
                GroupIdentityInteractionTag d26 = TroopIdentityPreviewPart.this.A9().d2();
                ImageView imageView4 = null;
                if (d26 != null) {
                    TroopIdentityPreviewPart troopIdentityPreviewPart = TroopIdentityPreviewPart.this;
                    imageView2 = troopIdentityPreviewPart.honorImageView;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("honorImageView");
                        imageView2 = null;
                    }
                    imageView2.setVisibility(0);
                    TroopIdentityHonorUtil troopIdentityHonorUtil = TroopIdentityHonorUtil.f300410a;
                    imageView3 = troopIdentityPreviewPart.honorImageView;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("honorImageView");
                    } else {
                        imageView4 = imageView3;
                    }
                    String str = d26.interactionTagId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.interactionTagId");
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                    troopIdentityHonorUtil.i(imageView4, troopIdentityHonorUtil.e(intOrNull));
                } else {
                    imageView = TroopIdentityPreviewPart.this.honorImageView;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("honorImageView");
                    } else {
                        imageView4 = imageView;
                    }
                    imageView4.setVisibility(8);
                }
                TroopIdentityPreviewPart.this.R9(getIdentityListRsp.appTag);
            }
        };
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityPreviewPart.N9(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> h26 = A9().h2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit> function12 = new Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityPreviewPart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityPreviewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                ImageView imageView;
                ImageView imageView2;
                ImageView imageView3;
                Integer intOrNull;
                TroopMemberNewLevelView troopMemberNewLevelView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                    return;
                }
                if (cVar instanceof c.C8816c) {
                    TroopIdentityPreviewPart.this.S9();
                    return;
                }
                ImageView imageView4 = null;
                TroopMemberNewLevelView troopMemberNewLevelView2 = null;
                ImageView imageView5 = null;
                if (cVar instanceof c.d) {
                    troopMemberNewLevelView = TroopIdentityPreviewPart.this.levelView;
                    if (troopMemberNewLevelView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("levelView");
                    } else {
                        troopMemberNewLevelView2 = troopMemberNewLevelView;
                    }
                    troopMemberNewLevelView2.setTroopMemberNewLevel(((c.d) cVar).a());
                    return;
                }
                if (cVar instanceof c.b) {
                    c.b bVar = (c.b) cVar;
                    if (bVar.a() != null) {
                        imageView2 = TroopIdentityPreviewPart.this.honorImageView;
                        if (imageView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("honorImageView");
                            imageView2 = null;
                        }
                        imageView2.setVisibility(0);
                        TroopIdentityHonorUtil troopIdentityHonorUtil = TroopIdentityHonorUtil.f300410a;
                        imageView3 = TroopIdentityPreviewPart.this.honorImageView;
                        if (imageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("honorImageView");
                        } else {
                            imageView5 = imageView3;
                        }
                        String str = bVar.a().interactionTagId;
                        Intrinsics.checkNotNullExpressionValue(str, "it.selectedHonorIcon.interactionTagId");
                        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                        troopIdentityHonorUtil.i(imageView5, troopIdentityHonorUtil.e(intOrNull));
                        return;
                    }
                    imageView = TroopIdentityPreviewPart.this.honorImageView;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("honorImageView");
                    } else {
                        imageView4 = imageView;
                    }
                    imageView4.setVisibility(8);
                    return;
                }
                if (cVar instanceof c.a) {
                    TroopIdentityPreviewPart.this.R9(((c.a) cVar).a());
                }
            }
        };
        h26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityPreviewPart.O9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P9(View rootView) {
        View findViewById = rootView.findViewById(R.id.f102195x9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_identity_preview_avatar)");
        this.avatar = (QQProAvatarView) findViewById;
        com.tencent.mobileqq.proavatar.e a16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(100).a();
        QQProAvatarView qQProAvatarView = this.avatar;
        ImageView imageView = null;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            qQProAvatarView = null;
        }
        qQProAvatarView.x(1, A9().c2(), a16);
        View findViewById2 = rootView.findViewById(R.id.f102235xc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026entity_preview_nick_name)");
        this.nickNameTv = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f102225xb);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ntity_preview_level_view)");
        this.levelView = (TroopMemberNewLevelView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f102205x_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026ntity_preview_honor_view)");
        this.honorImageView = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f102185x8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026dentity_preview_app_view)");
        this.appIconImageView = (ImageView) findViewById5;
        ImageView imageView2 = this.honorImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("honorImageView");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        ImageView imageView3 = this.appIconImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appIconImageView");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
        S9();
        final LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.f27420g7);
        linearLayout.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.m
            @Override // java.lang.Runnable
            public final void run() {
                TroopIdentityPreviewPart.Q9(linearLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(LinearLayout linearLayout) {
        int dpToPx = ViewUtils.dpToPx(246.0f);
        if (linearLayout.getWidth() > dpToPx) {
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.width = dpToPx;
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(GroupIdentityAppTag appTag) {
        boolean z16;
        Drawable drawable;
        ITroopGameCardService iTroopGameCardService;
        ImageView imageView = null;
        if (appTag != null && appTag.status) {
            String str = appTag.appTagId;
            Intrinsics.checkNotNullExpressionValue(str, "appTag.appTagId");
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ImageView imageView2 = this.appIconImageView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appIconImageView");
                    imageView2 = null;
                }
                imageView2.setVisibility(0);
                if (Intrinsics.areEqual(appTag.appTagId, "1")) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null && (iTroopGameCardService = (ITroopGameCardService) peekAppRuntime.getRuntimeService(ITroopGameCardService.class, "")) != null) {
                        drawable = iTroopGameCardService.getDrawableByGameGradeLevel(appTag.level * 10000, null);
                    } else {
                        drawable = null;
                    }
                    ImageView imageView3 = this.appIconImageView;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("appIconImageView");
                    } else {
                        imageView = imageView3;
                    }
                    imageView.setImageDrawable(drawable);
                    return;
                }
                if (Intrinsics.areEqual(appTag.appTagId, "2")) {
                    TroopIdentityHonorUtil troopIdentityHonorUtil = TroopIdentityHonorUtil.f300410a;
                    ImageView imageView4 = this.appIconImageView;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("appIconImageView");
                    } else {
                        imageView = imageView4;
                    }
                    troopIdentityHonorUtil.i(imageView, appTag.icon);
                    return;
                }
                return;
            }
        }
        ImageView imageView5 = this.appIconImageView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appIconImageView");
        } else {
            imageView = imageView5;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        String str;
        TroopMemberNickInfo troopMemberNickInfo;
        TroopMemberInfo f26 = A9().f2();
        if (f26 == null || (troopMemberNickInfo = f26.nickInfo) == null || (str = troopMemberNickInfo.getShowName()) == null) {
            str = "";
        }
        String str2 = str;
        TextView textView = this.nickNameTv;
        TroopMemberNewLevelView troopMemberNewLevelView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickNameTv");
            textView = null;
        }
        textView.setText(IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), str2, 16, 13, null, null, 24, null));
        TroopMemberNewLevelView troopMemberNewLevelView2 = this.levelView;
        if (troopMemberNewLevelView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("levelView");
        } else {
            troopMemberNewLevelView = troopMemberNewLevelView2;
        }
        troopMemberNewLevelView.setTroopMemberNewLevel(A9().a2());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.f102155x5);
        View previewLayout = LayoutInflater.from(getContext()).inflate(R.layout.hzh, (ViewGroup) linearLayout, false);
        if (linearLayout != null) {
            linearLayout.addView(previewLayout);
        }
        Intrinsics.checkNotNullExpressionValue(previewLayout, "previewLayout");
        P9(previewLayout);
        M9();
    }
}
