package com.tencent.mobileqq.guild.media.thirdapp;

import android.media.ImageReader;
import android.os.Build;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/c;", "", "", "a", "Landroid/media/ImageReader;", "b", "Landroid/media/ImageReader;", "imageReader", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f229224a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile ImageReader imageReader;

    c() {
    }

    public final synchronized void a() {
        Logger.f235387a.d().d("GuildMediaImageReaderHolder", 1, "[releaseImageReader] try destroy");
        ImageReader imageReader2 = imageReader;
        if (imageReader2 != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                imageReader2.discardFreeBuffers();
            }
            imageReader2.close();
        }
        imageReader = null;
    }
}
