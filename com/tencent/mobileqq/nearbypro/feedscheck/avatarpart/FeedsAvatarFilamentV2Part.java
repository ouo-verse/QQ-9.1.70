package com.tencent.mobileqq.nearbypro.feedscheck.avatarpart;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.avatar.AvatarData;
import com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarView;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.feedscheck.basepart.NearbyProFeedsBasePart;
import com.tencent.mobileqq.nearbypro.feedscheck.basepart.StatusFeedData;
import com.tencent.mobileqq.nearbypro.utils.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.state.square.data.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import op4.g;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp4.f;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/avatarpart/FeedsAvatarFilamentV2Part;", "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/NearbyProFeedsBasePart;", "", "position", "", "J9", "Lop4/i;", "statusFeed", "M9", "L9", "", "noPic", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarView;", h.F, "Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarView;", "avatarView", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "avatarViewContainer", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "currentViewSize", BdhLogUtil.LogTag.Tag_Conn, "lastViewSize", "<init>", "()V", "D", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FeedsAvatarFilamentV2Part extends NearbyProFeedsBasePart {

    /* renamed from: C, reason: from kotlin metadata */
    private float lastViewSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NearbyAvatarView avatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup avatarViewContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float currentViewSize;

    /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void J9(int position) {
        boolean z16;
        boolean z17;
        boolean z18;
        List<StatusFeedData> value = E9().Z1().getValue();
        if (value != null) {
            StatusFeedData statusFeedData = value.get(position);
            if (statusFeedData.getStatusFeedType() != 1 && statusFeedData.getStatusFeed() != null && statusFeedData.getStatusFeedType() != 3) {
                if (this.avatarView == null) {
                    M9(statusFeedData.getStatusFeed());
                }
                g[] gVarArr = statusFeedData.getStatusFeed().f423356f;
                if (gVarArr != null) {
                    if (gVarArr.length == 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        z16 = false;
                        K9(z16);
                        NearbyAvatarView nearbyAvatarView = this.avatarView;
                        Intrinsics.checkNotNull(nearbyAvatarView);
                        nearbyAvatarView.setVisibility(0);
                        MutableLiveData<AvatarData> W1 = E9().W1();
                        String longToString = StringUtil.longToString(statusFeedData.getStatusFeed().f423352b.f434140a);
                        Intrinsics.checkNotNullExpressionValue(longToString, "longToString(feedsData.statusFeed.poster.tid)");
                        if (statusFeedData.getStatusFeed().f423352b.f434144e == 2) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        f fVar = statusFeedData.getStatusFeed().f423354d;
                        Intrinsics.checkNotNullExpressionValue(fVar, "feedsData.statusFeed.filament");
                        W1.setValue(new AvatarData(longToString, z17, e.f(fVar, null, 1, null), false, 8, null));
                        return;
                    }
                }
                z16 = true;
                K9(z16);
                NearbyAvatarView nearbyAvatarView2 = this.avatarView;
                Intrinsics.checkNotNull(nearbyAvatarView2);
                nearbyAvatarView2.setVisibility(0);
                MutableLiveData<AvatarData> W12 = E9().W1();
                String longToString2 = StringUtil.longToString(statusFeedData.getStatusFeed().f423352b.f434140a);
                Intrinsics.checkNotNullExpressionValue(longToString2, "longToString(feedsData.statusFeed.poster.tid)");
                if (statusFeedData.getStatusFeed().f423352b.f434144e == 2) {
                }
                f fVar2 = statusFeedData.getStatusFeed().f423354d;
                Intrinsics.checkNotNullExpressionValue(fVar2, "feedsData.statusFeed.filament");
                W12.setValue(new AvatarData(longToString2, z17, e.f(fVar2, null, 1, null), false, 8, null));
                return;
            }
            NearbyAvatarView nearbyAvatarView3 = this.avatarView;
            if (nearbyAvatarView3 != null) {
                nearbyAvatarView3.setVisibility(8);
            }
            K9(true);
        }
    }

    private final void K9(boolean noPic) {
        float f16;
        ViewGroup.LayoutParams layoutParams;
        float f17;
        if (noPic) {
            f16 = 375.0f;
        } else {
            f16 = 260.0f;
        }
        NearbyAvatarView nearbyAvatarView = this.avatarView;
        if (nearbyAvatarView == null) {
            j.c().d("NBP.FeedsCheckPart.NearbyProFeedsAvatarPart", "check avatar is null!");
            return;
        }
        Intrinsics.checkNotNull(nearbyAvatarView);
        nearbyAvatarView.getLayoutParams().width = ViewUtils.dpToPx(f16);
        NearbyAvatarView nearbyAvatarView2 = this.avatarView;
        Intrinsics.checkNotNull(nearbyAvatarView2);
        nearbyAvatarView2.getLayoutParams().height = ViewUtils.dpToPx(f16);
        NearbyAvatarView nearbyAvatarView3 = this.avatarView;
        Intrinsics.checkNotNull(nearbyAvatarView3);
        nearbyAvatarView3.requestLayout();
        this.currentViewSize = f16;
        ViewGroup viewGroup = this.avatarViewContainer;
        if (viewGroup != null) {
            layoutParams = viewGroup.getLayoutParams();
        } else {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (noPic) {
            f17 = 76.0f;
        } else {
            f17 = 8.0f;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = ViewUtils.dpToPx(f17);
        }
        ViewGroup viewGroup2 = this.avatarViewContainer;
        if (viewGroup2 != null) {
            viewGroup2.setLayoutParams(marginLayoutParams);
        }
    }

    private final void M9(i statusFeed) {
        boolean z16;
        final NearbyAvatarView initAvatarView$lambda$2 = (NearbyAvatarView) getPartRootView().findViewById(R.id.znv);
        Intrinsics.checkNotNullExpressionValue(initAvatarView$lambda$2, "initAvatarView$lambda$2");
        String longToString = StringUtil.longToString(statusFeed.f423352b.f434140a);
        Intrinsics.checkNotNullExpressionValue(longToString, "longToString(statusFeed.poster.tid)");
        if (statusFeed.f423352b.f434144e != 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        f fVar = statusFeed.f423354d;
        Intrinsics.checkNotNullExpressionValue(fVar, "statusFeed.filament");
        NearbyAvatarView.f(initAvatarView$lambda$2, new AvatarData(longToString, z16, e.f(fVar, null, 1, null), false, 8, null), false, null, null, null, 30, null);
        MutableLiveData<AvatarData> W1 = E9().W1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<AvatarData, Unit> function1 = new Function1<AvatarData, Unit>() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.avatarpart.FeedsAvatarFilamentV2Part$initAvatarView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AvatarData avatarData) {
                invoke2(avatarData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AvatarData avatarData) {
                float f16;
                float f17;
                float f18;
                if (avatarData != null) {
                    NearbyAvatarView nearbyAvatarView = NearbyAvatarView.this;
                    Resource resource = avatarData.getResource();
                    AnonymousClass1 anonymousClass1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.avatarpart.FeedsAvatarFilamentV2Part$initAvatarView$1$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable Boolean bool) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke2(bool);
                            return Unit.INSTANCE;
                        }
                    };
                    f16 = this.lastViewSize;
                    f17 = this.currentViewSize;
                    nearbyAvatarView.j(resource, anonymousClass1, !(f16 == f17));
                    FeedsAvatarFilamentV2Part feedsAvatarFilamentV2Part = this;
                    f18 = feedsAvatarFilamentV2Part.currentViewSize;
                    feedsAvatarFilamentV2Part.lastViewSize = f18;
                }
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.avatarpart.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedsAvatarFilamentV2Part.N9(Function1.this, obj);
            }
        });
        this.avatarView = initAvatarView$lambda$2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "LIST_SELECT_ITEM_POSITION")) {
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type kotlin.Int");
            J9(((Integer) args).intValue());
        } else if (Intrinsics.areEqual(action, "CLICK_MORE_POS")) {
            L9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.avatarViewContainer = (ViewGroup) rootView.findViewById(R.id.t17);
    }

    private final void L9() {
    }
}
