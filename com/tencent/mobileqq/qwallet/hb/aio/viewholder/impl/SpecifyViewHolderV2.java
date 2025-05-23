package com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.hb.aio.impl.d;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import d4.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vk2.QWalletMsgModel;
import vk2.QWalletSessionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J$\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aio/viewholder/impl/SpecifyViewHolderV2;", "Lcom/tencent/mobileqq/qwallet/hb/aio/viewholder/impl/BaseViewHolderV2;", "Landroid/widget/LinearLayout;", "r", "", "tinyId", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", ReportConstant.COSTREPORT_PREFIX, "uin", "Landroid/widget/ImageView;", "t", "Lkotlin/Function1;", "", "callback", "u", "b", "c", "", "e", "", "", "v", "()Ljava/util/List;", "specifyUinList", "Ld4/f;", "parentViewHolder", "Lvk2/d;", "model", "Lvk2/e;", "sessionInfo", "<init>", "(Ld4/f;Lvk2/d;Lvk2/e;)V", "i", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class SpecifyViewHolderV2 extends BaseViewHolderV2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecifyViewHolderV2(@NotNull f parentViewHolder, @NotNull QWalletMsgModel model, @NotNull QWalletSessionInfo sessionInfo) {
        super(parentViewHolder, model, sessionInfo);
        Intrinsics.checkNotNullParameter(parentViewHolder, "parentViewHolder");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
    }

    private final LinearLayout r() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        getParentViewHolder().f().addView(linearLayout);
        return linearLayout;
    }

    private final GuildUserAvatarView s(String tinyId) {
        GuildUserAvatarView guildUserAvatarView = new GuildUserAvatarView(getContext());
        guildUserAvatarView.setScaleType(ImageView.ScaleType.FIT_XY);
        guildUserAvatarView.setAvatarTinyId(getSessionInfo().getTroopUin(), tinyId);
        return guildUserAvatarView;
    }

    private final ImageView t(String uin) {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(R.drawable.frt);
        int c16 = x.c(getContext(), 1.0f);
        imageView.setPadding(c16, c16, c16, c16);
        imageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(h(), uin, (byte) 4));
        return imageView;
    }

    private final void u(String uin, final Function1<? super String, Unit> callback) {
        if (getSessionInfo().getCurType() == 10014) {
            String a16 = d.a(h(), getSessionInfo().getTroopUin(), uin);
            Intrinsics.checkNotNullExpressionValue(a16, "getDisplayName(app, sessionInfo.troopUin, uin)");
            callback.invoke(a16);
            return;
        }
        ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickName(getSessionInfo().getTroopUin(), uin, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.SpecifyViewHolderV2$getNickName$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.invoke(it);
            }
        });
    }

    private final List<Long> v() {
        return getModel().getHbModel().f();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.BaseViewHolderV2, yk2.a
    public void b() {
        int i3;
        ImageView t16;
        int i16 = 0;
        o(0);
        LinearLayout r16 = r();
        if (v().size() < 4) {
            i3 = ScreenUtil.dip2px(6.0f);
        } else {
            i3 = -x.c(getContext(), 5.0f);
        }
        int c16 = x.c(getContext(), 27.0f);
        for (Object obj : v()) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            long longValue = ((Number) obj).longValue();
            if (i16 < 5) {
                if (getSessionInfo().getCurType() == 10014) {
                    t16 = s(String.valueOf(longValue));
                } else {
                    t16 = t(String.valueOf(longValue));
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c16, c16);
                if (i16 > 0) {
                    layoutParams.leftMargin = i3;
                }
                r16.addView(t16, layoutParams);
            }
            i16 = i17;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.BaseViewHolderV2, yk2.a
    public void c() {
        if (v().isEmpty()) {
            TextView c16 = getParentViewHolder().c();
            if (c16 != null) {
                c16.setVisibility(8);
                return;
            }
            return;
        }
        u(String.valueOf(v().get(0).longValue()), new SpecifyViewHolderV2$handlesubTitle$1(this));
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.viewholder.impl.BaseViewHolderV2, yk2.a
    public boolean e() {
        boolean e16 = super.e();
        if (!e16) {
            getParentViewHolder().a().setVisibility(0);
            getParentViewHolder().a().setText("\u4e13\u5c5e\u7ea2\u5305");
        }
        return e16;
    }
}
