package org.light.lightAssetKit;

import com.google.gson.JsonObject;
import org.light.lightAssetKit.components.Component;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseContext {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onAddComponent(int i3, JsonObject jsonObject);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onAddEntity(int i3, int i16, Entity entity);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onRegisterComponentUpdateMonitor(Component component);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onRemoveComponent(int i3, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onRemoveEntity(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onUnregisterComponentUpdateMonitor(Component component);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onUpdateComponent(int i3, String str, JsonObject jsonObject);
}
