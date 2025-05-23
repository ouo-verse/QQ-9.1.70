package com.tencent.sqshow.zootopia.avatar.filament.anim;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0007\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/anim/g;", "", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/a;", "b", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/a;", "()Lcom/tencent/sqshow/zootopia/avatar/filament/anim/a;", "INIT_ANIM_M_PATH", "c", "a", "INIT_ANIM_F_PATH", "", "d", "Ljava/util/List;", "()Ljava/util/List;", "RANDOM_ANIM_M_PATH", "e", "RANDOM_ANIM_F_PATH", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f370004a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final AnimPath INIT_ANIM_M_PATH = new AnimPath("CMShow/Assets/Animation/Character/Player/Animation/AnimSequence/A_Male/StandingSideways/HeadAnimation/A_CH_M_Idle_Emote_Anim", "CMShow/Assets/Animation/Character/Player/Animation/AnimSequence/A_Male/StandingSideways/BodyAnimation/A_CH_M_Idle");

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final AnimPath INIT_ANIM_F_PATH = new AnimPath("CMShow/Assets/Animation/Character/Player/Animation/AnimSequence/A_Female/StandingSideways/HeadAnimation/A_CH_F_Idle_Emote_Anim", "CMShow/Assets/Animation/Character/Player/Animation/AnimSequence/A_Female/StandingSideways/BodyAnimation/A_CH_F_Idle");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final List<AnimPath> RANDOM_ANIM_M_PATH;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final List<AnimPath> RANDOM_ANIM_F_PATH;

    static {
        List<AnimPath> listOf;
        List<AnimPath> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AnimPath[]{new AnimPath("CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Male/zengliang/HeadAnimation/A_CH_M_G_Relax_2_Emote_Anim_2", "CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Male/zengliang/BodyAnimation/A_CH_M_G_Relax_2_2"), new AnimPath("CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Male/zengliang/HeadAnimation/A_CH_M_G_Relax_2_Emote_Anim_1", "CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Male/zengliang/BodyAnimation/A_CH_M_G_Relax_2_1")});
        RANDOM_ANIM_M_PATH = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new AnimPath[]{new AnimPath("CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Female/zengliang/HeadAnimation/A_CH_F_Relax_1_Emote_Anim_1", "CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Female/zengliang/BodyAnimation/A_CH_F_Relax_1"), new AnimPath("CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Female/zengliang/HeadAnimation/A_CH_F_Relax_1_Emote_Anim_2", "CMShow/Assets/AnimationUnpak/Character/Player/Animation/AnimSequence/A_Female/zengliang/BodyAnimation/A_CH_F_Relax_2")});
        RANDOM_ANIM_F_PATH = listOf2;
    }

    g() {
    }

    public final AnimPath a() {
        return INIT_ANIM_F_PATH;
    }

    public final AnimPath b() {
        return INIT_ANIM_M_PATH;
    }

    public final List<AnimPath> c() {
        return RANDOM_ANIM_F_PATH;
    }

    public final List<AnimPath> d() {
        return RANDOM_ANIM_M_PATH;
    }
}
