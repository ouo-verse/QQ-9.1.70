package com.qzone.reborn.share;

import android.graphics.Bitmap;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\r\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/share/d;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", WadlProxyConsts.SCENE_ID, "d", "g", "(Ljava/lang/String;)V", "title", "", "c", "Z", "e", "()Z", "f", "(Z)V", "isHideRecentContact", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "setPreviewBitmap", "(Landroid/graphics/Bitmap;)V", "previewBitmap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/qzone/reborn/share/f;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setSharePanelListenerList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "sharePanelListenerList", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isHideRecentContact;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Bitmap previewBitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<f> sharePanelListenerList;

    public d(String sceneId) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        this.sceneId = sceneId;
        this.title = "";
        this.sharePanelListenerList = new CopyOnWriteArrayList<>();
    }

    /* renamed from: a, reason: from getter */
    public final Bitmap getPreviewBitmap() {
        return this.previewBitmap;
    }

    /* renamed from: b, reason: from getter */
    public final String getSceneId() {
        return this.sceneId;
    }

    public final CopyOnWriteArrayList<f> c() {
        return this.sharePanelListenerList;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsHideRecentContact() {
        return this.isHideRecentContact;
    }

    public final void f(boolean z16) {
        this.isHideRecentContact = z16;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
