package com.tencent.mobileqq.zplan.aigc.helper;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.aigc.data.SuitAnimationItem;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J1\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J7\u0010\u0015\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bJ\"\u0010\u0018\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0000R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/AigcAnimHelper;", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "Lcom/tencent/filament/zplan/data/FetchActionData;", "B1", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "h0", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewer", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "callback", "E1", "Lcom/tencent/filament/zplan/animation/b;", "C1", "", "Lcom/tencent/mobileqq/zplan/aigc/data/SuitAnimationItem;", "suitActions", "z1", "isHandHeldItem", "isLoop", Constants.BASE_IN_PLUGIN_ID, "", "A1", "animHelper", "F1", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "ueGender", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/filament/zplan/animation/b;", "mUgcThumbnailAnim", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "mSuitOutfitActionList", "T", "I", "currentAnimIndex", "<init>", "(Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;)V", "U", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AigcAnimHelper extends PortalAnimHelper {

    /* renamed from: Q, reason: from kotlin metadata */
    private final UEAvatarGender ueGender;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.filament.zplan.animation.b mUgcThumbnailAnim;

    /* renamed from: S, reason: from kotlin metadata */
    private List<ZPlanAction> mSuitOutfitActionList;

    /* renamed from: T, reason: from kotlin metadata */
    private int currentAnimIndex;

    public AigcAnimHelper(UEAvatarGender ueGender) {
        Intrinsics.checkNotNullParameter(ueGender, "ueGender");
        this.ueGender = ueGender;
        this.mSuitOutfitActionList = new ArrayList();
        this.currentAnimIndex = -1;
    }

    private final FetchActionData B1() {
        if (this.ueGender == UEAvatarGender.FEMALE) {
            return new FetchActionData(0, com.tencent.sqshow.zootopia.avatar.filament.anim.g.f370004a.a().getHead(), "CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/UgcThumbnail/BodyAnimation/QQ_N_UgcThumbnail_01", 1, null);
        }
        return new FetchActionData(0, com.tencent.sqshow.zootopia.avatar.filament.anim.g.f370004a.b().getHead(), "CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/UgcThumbnail/BodyAnimation/QQ_N_UgcThumbnail_01", 1, null);
    }

    /* renamed from: A1, reason: from getter */
    public final int getCurrentAnimIndex() {
        return this.currentAnimIndex;
    }

    /* renamed from: C1, reason: from getter */
    public final com.tencent.filament.zplan.animation.b getMUgcThumbnailAnim() {
        return this.mUgcThumbnailAnim;
    }

    public final void E1(FilamentViewerV2 viewer, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(super.getScope(), null, null, new AigcAnimHelper$loadUgcThumbnailAnimation$1(callback, this, this.ueGender.toEnumUserGender(), B1(), viewer, null), 3, null);
    }

    public final void F1(AigcAnimHelper animHelper) {
        Intrinsics.checkNotNullParameter(animHelper, "animHelper");
        this.mSuitOutfitActionList = animHelper.mSuitOutfitActionList;
        this.currentAnimIndex = animHelper.currentAnimIndex - 1;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper
    /* renamed from: h0, reason: from getter */
    public UEAvatarGender getUeGender() {
        return this.ueGender;
    }

    public final void z1(List<SuitAnimationItem> suitActions, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(suitActions, "suitActions");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(super.getScope(), null, null, new AigcAnimHelper$fetchOutfitPreviewActions$1(callback, suitActions, this, this.ueGender.toEnumUserGender(), null), 3, null);
    }

    public final boolean D1(FilamentViewerV2 viewer, boolean isHandHeldItem, boolean isLoop) {
        if (viewer == null || this.mSuitOutfitActionList.isEmpty()) {
            return false;
        }
        int i3 = this.currentAnimIndex + 1;
        this.currentAnimIndex = i3;
        if (i3 >= this.mSuitOutfitActionList.size()) {
            this.currentAnimIndex = 0;
        }
        int i16 = this.currentAnimIndex;
        if (i16 < 0) {
            return false;
        }
        s0(viewer, this.mSuitOutfitActionList.get(i16), isHandHeldItem, isLoop);
        return true;
    }
}
