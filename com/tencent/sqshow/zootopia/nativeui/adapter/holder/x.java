package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import b94.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PanelSubTitlePageDataRepo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J2\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007H\u0016J\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/x;", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/t;", "Luv4/bk;", "data", "", "posInList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "totalData", "", "e0", "Lqu4/a;", "avatarCharacter", "", "Luv4/az;", "storeItemList", BdhLogUtil.LogTag.Tag_Conn, "Ln74/s;", "binding", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "commonData", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;", "panelSubTitlePageDataRepo", "<init>", "(Ln74/s;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;)V", "f0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class x extends t {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(n74.s binding, com.tencent.sqshow.zootopia.nativeui.data.j commonData, PanelSubTitlePageDataRepo panelSubTitlePageDataRepo) {
        super(binding, commonData, panelSubTitlePageDataRepo);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(commonData, "commonData");
        Intrinsics.checkNotNullParameter(panelSubTitlePageDataRepo, "panelSubTitlePageDataRepo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(x this$0, b94.d dressController, UEAvatarGender targetGender, List storeItemList, qu4.a avatarCharacter) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dressController, "$dressController");
        Intrinsics.checkNotNullParameter(targetGender, "$targetGender");
        Intrinsics.checkNotNullParameter(storeItemList, "$storeItemList");
        Intrinsics.checkNotNullParameter(avatarCharacter, "$avatarCharacter");
        this$0.b0("clickItem#doDressFullItemList  running");
        this$0.w();
        dressController.Bg(targetGender, storeItemList, avatarCharacter, this$0.getDressCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(x this$0, Runnable dressTask) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dressTask, "$dressTask");
        this$0.v();
        dressTask.run();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void C(final qu4.a avatarCharacter, final List<az> storeItemList) {
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        Intrinsics.checkNotNullParameter(storeItemList, "storeItemList");
        UEAvatarGender n3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n();
        boolean B = r94.b.B(n3, Integer.valueOf(avatarCharacter.f429576e));
        if (B) {
            UEAvatarGender uEAvatarGender = UEAvatarGender.FEMALE;
            n3 = n3 == uEAvatarGender ? UEAvatarGender.MALE : uEAvatarGender;
        }
        b0("clickItem#doDressFullItemList - size = " + storeItemList.size() + ", needSwitchGender = " + B);
        final b94.d avatarDressController = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getAvatarDressController();
        if (avatarDressController != null) {
            final UEAvatarGender uEAvatarGender2 = n3;
            final Runnable runnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.v
                @Override // java.lang.Runnable
                public final void run() {
                    x.B1(x.this, avatarDressController, uEAvatarGender2, storeItemList, avatarCharacter);
                }
            };
            if (!B) {
                runnable.run();
                return;
            }
            x();
            b94.d avatarDressController2 = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getAvatarDressController();
            if (avatarDressController2 != null) {
                d.a.c(avatarDressController2, n3, null, new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.C1(x.this, runnable);
                    }
                }, 2, null);
            }
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.t, com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void e0(bk data, int posInList, ArrayList<bk> totalData) {
        Intrinsics.checkNotNullParameter(totalData, "totalData");
        super.e0(data, posInList, totalData);
        if (f1()) {
            getBinding().f419405d.setText(getBinding().getRoot().getContext().getString(R.string.xse));
        }
    }
}
