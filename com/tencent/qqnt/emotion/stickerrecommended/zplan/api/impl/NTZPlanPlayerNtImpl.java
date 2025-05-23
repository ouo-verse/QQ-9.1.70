package com.tencent.qqnt.emotion.stickerrecommended.zplan.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.aio.api.runtime.a;
import com.tencent.common.app.AppInterface;
import com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J(\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/zplan/api/impl/NTZPlanPlayerNtImpl;", "Lcom/tencent/qqnt/emotion/stickerrecommended/zplan/api/INTZPlanPlayer;", "", "isReady", "", "play", "pause", "resume", "stop", "Landroid/view/View;", "getView", "Landroid/content/Context;", "context", "", "width", "height", "Lcom/tencent/common/app/AppInterface;", "app", "init", "Lcom/tencent/aio/api/runtime/a;", "baseAIOContext", "onSend", "Lorg/json/JSONObject;", "jsonObject", "setJson", "isPlaying", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NTZPlanPlayerNtImpl implements INTZPlanPlayer {
    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    @Nullable
    public View getView() {
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void init(@NotNull Context context, int width, int height, @NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public boolean isPlaying() {
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public boolean isReady() {
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void onSend(@NotNull AppInterface app, @Nullable a baseAIOContext) {
        Intrinsics.checkNotNullParameter(app, "app");
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void pause() {
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void play() {
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void resume() {
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void stop() {
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void setJson(@Nullable JSONObject jsonObject, @Nullable a baseAIOContext) {
    }
}
