package com.tencent.timi.game.room.impl;

import fm4.o;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected YoloRoomManager f379169a;

    /* renamed from: b, reason: collision with root package name */
    protected o f379170b;

    public a(YoloRoomManager yoloRoomManager, o oVar) {
        this.f379169a = yoloRoomManager;
        this.f379170b = oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(int i3, YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction);
}
