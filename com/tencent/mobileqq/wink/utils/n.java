package com.tencent.mobileqq.wink.utils;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioOutputConfig;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.VideoOutputConfig;
import org.light.lightAssetKit.components.AudioSource;
import org.light.lightAssetKit.components.Image;
import org.light.lightAssetKit.components.MultiMedia;
import org.light.lightAssetKit.components.PAGAsset;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/n;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "Lorg/light/ClipPlaceHolder;", "a", "", "templateFilePath", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f326718a = new n();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/n$a;", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final String f326720b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private static final String f326721c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private static final String f326722d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        private static final String f326723e;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/n$a$a;", "", "", "PAG_ASSET", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "IMAGE", "b", "AUDIO_SOURCE", "a", "MULTI_MEDIA", "c", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.utils.n$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes21.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final String a() {
                return a.f326722d;
            }

            @NotNull
            public final String b() {
                return a.f326721c;
            }

            @NotNull
            public final String c() {
                return a.f326723e;
            }

            @NotNull
            public final String d() {
                return a.f326720b;
            }

            Companion() {
            }
        }

        static {
            String type = new PAGAsset().type();
            Intrinsics.checkNotNullExpressionValue(type, "PAGAsset().type()");
            f326720b = type;
            String type2 = new Image().type();
            Intrinsics.checkNotNullExpressionValue(type2, "Image().type()");
            f326721c = type2;
            String type3 = new AudioSource().type();
            Intrinsics.checkNotNullExpressionValue(type3, "AudioSource().type()");
            f326722d = type3;
            String type4 = new MultiMedia().type();
            Intrinsics.checkNotNullExpressionValue(type4, "MultiMedia().type()");
            f326723e = type4;
        }
    }

    n() {
    }

    @Nullable
    public final List<ClipPlaceHolder> a(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        String m3 = WinkEditorResourceManager.a1().m(material);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
        return b(m3);
    }

    @Nullable
    public final List<ClipPlaceHolder> b(@NotNull String templateFilePath) {
        List<ClipPlaceHolder> list;
        MovieController assetForMovie;
        ClipPlaceHolder[] clipPlaceHolders;
        Intrinsics.checkNotNullParameter(templateFilePath, "templateFilePath");
        y yVar = y.f326739a;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        yVar.b(context);
        LightAsset Load = LightAsset.Load(templateFilePath, 0);
        LightEngine make = LightEngine.make(new VideoOutputConfig(30.0f, 0), new AudioOutputConfig(), new RendererConfig());
        if (make != null && (assetForMovie = make.setAssetForMovie(Load)) != null && (clipPlaceHolders = assetForMovie.getClipPlaceHolders()) != null) {
            list = ArraysKt___ArraysKt.toList(clipPlaceHolders);
        } else {
            list = null;
        }
        if (make != null) {
            make.release();
        }
        return list;
    }
}
