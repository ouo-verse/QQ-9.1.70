package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H&j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "", "Lcom/tencent/mobileqq/zplan/minihome/al;", "getSceneConfig", "<init>", "(Ljava/lang/String;I)V", "SCENE_PROFILE", "SCENE_CREATE", "SCENE_EDIT", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public enum MiniHomeSceneEnum {
    SCENE_PROFILE { // from class: com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum.SCENE_PROFILE
        @Override // com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum
        @NotNull
        public al getSceneConfig() {
            al alVar = new al();
            alVar.j(false);
            alVar.i(true);
            alVar.h(true);
            alVar.g(true);
            alVar.f(FirstFrameType.ROOM_ONLY.ordinal());
            return alVar;
        }
    },
    SCENE_CREATE { // from class: com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum.SCENE_CREATE
        @Override // com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum
        @NotNull
        public al getSceneConfig() {
            al alVar = new al();
            alVar.j(true);
            alVar.i(true);
            alVar.h(true);
            alVar.f(FirstFrameType.ROOM_ONLY.ordinal());
            return alVar;
        }
    },
    SCENE_EDIT { // from class: com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum.SCENE_EDIT
        @Override // com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum
        @NotNull
        public al getSceneConfig() {
            al alVar = new al();
            alVar.h(false);
            alVar.g(false);
            alVar.f(FirstFrameType.ROOM_ONLY.ordinal());
            return alVar;
        }
    };

    /* synthetic */ MiniHomeSceneEnum(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract al getSceneConfig();
}
