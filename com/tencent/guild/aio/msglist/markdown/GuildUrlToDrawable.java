package com.tencent.guild.aio.msglist.markdown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.widget.ImageView;
import com.tencent.android.androidbypass.enhance.drawable.image.LoadFailedDrawable;
import com.tencent.android.androidbypass.enhance.drawable.image.LoadingDrawable;
import com.tencent.android.androidbypass.enhance.g;
import com.tencent.android.androidbypass.enhance.h;
import com.tencent.guild.aio.msglist.markdown.GuildUrlToDrawable;
import com.tencent.guild.aio.util.aa;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0010\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R&\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/GuildUrlToDrawable;", "Lcom/tencent/android/androidbypass/enhance/g;", "Lcom/tencent/android/androidbypass/enhance/h$a;", "proxy", "", "url", "", h.F, "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/android/androidbypass/enhance/drawable/a;", "g", "c", "Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/enhance/h$b;", "a", "Landroid/graphics/drawable/Drawable;", "b", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "mProxyHashMaps", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildUrlToDrawable implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, List<h.a>> mProxyHashMaps = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildUrlToDrawable$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/request/Option;", "option", "", "d", "Lcom/tencent/libra/LoadState;", "state", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f111728e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ h.b f111729f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ GuildUrlToDrawable f111730h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f111731i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, h.b bVar, GuildUrlToDrawable guildUrlToDrawable, Context context) {
            super(true);
            this.f111728e = str;
            this.f111729f = bVar;
            this.f111730h = guildUrlToDrawable;
            this.f111731i = context;
        }

        private final void d(Option option) {
            Bitmap resultBitMap = option.getResultBitMap();
            Object animatable = option.getAnimatable();
            if (resultBitMap != null) {
                this.f111729f.o(resultBitMap);
            } else if (animatable instanceof Drawable) {
                this.f111729f.n((Drawable) animatable);
            } else {
                QLog.e("GuildUrlToDrawable", 1, "[onLoadSuccess]: but option doesn't has any drawable, seq=" + option.getSeq());
            }
            fq0.a aVar = fq0.a.f400309a;
            String localPath = option.getLocalPath();
            Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
            aVar.t(localPath, this.f111729f);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            Integer num;
            if (state == LoadState.STATE_SUCCESS && option != null) {
                d(option);
                return;
            }
            boolean z16 = false;
            if (state != null && state.isFinishError()) {
                z16 = true;
            }
            if (z16) {
                if (option != null) {
                    num = Integer.valueOf(option.getSeq());
                } else {
                    num = null;
                }
                QLog.e("GuildUrlToDrawable", 1, "[onLoadPicture]: failed, seq=" + num + " url=" + this.f111728e);
                this.f111729f.l(this.f111730h.f(this.f111731i));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/msglist/markdown/GuildUrlToDrawable$c", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends GuildPicStateListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f111733f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f111734h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ h.a f111735i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, long j3, h.a aVar) {
            super(true);
            this.f111733f = str;
            this.f111734h = j3;
            this.f111735i = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(h.a proxy, Drawable drawable) {
            Intrinsics.checkNotNullParameter(proxy, "$proxy");
            proxy.b(drawable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(h.a proxy, GuildUrlToDrawable this$0) {
            Intrinsics.checkNotNullParameter(proxy, "$proxy");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            proxy.l(this$0.f(proxy.x()));
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            float f16;
            final com.tencent.android.androidbypass.enhance.drawable.a aVar;
            com.tencent.android.androidbypass.enhance.drawable.a g16;
            com.tencent.android.androidbypass.enhance.drawable.a k3;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (option.getResultBitMap() == null && option.getAnimatable() == null) {
                if (state.isFinishError()) {
                    QLog.e("GuildUrlToDrawable", 1, "onBitmapFailed: url=" + this.f111733f + ", " + this.f111734h);
                    final h.a aVar2 = this.f111735i;
                    final GuildUrlToDrawable guildUrlToDrawable = GuildUrlToDrawable.this;
                    aa.b(new Runnable() { // from class: com.tencent.guild.aio.msglist.markdown.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildUrlToDrawable.c.g(h.a.this, guildUrlToDrawable);
                        }
                    });
                    return;
                }
                QLog.e("GuildUrlToDrawable", 1, "onOtherState: url=" + this.f111733f + ", " + this.f111734h + " state:" + state);
                return;
            }
            List<h.a> list = (List) GuildUrlToDrawable.this.mProxyHashMaps.get(this.f111733f);
            if (list != null) {
                for (final h.a aVar3 : list) {
                    option.getResultBitMap();
                    if (com.tencent.android.androidbypass.enhance.c.a(aVar3.x()).b(aVar3.C()) < 106.0f) {
                        f16 = 4.0f;
                    } else {
                        f16 = 6.0f;
                    }
                    int z16 = aVar3.z(ViewUtils.dip2px(f16));
                    com.tencent.android.androidbypass.enhance.drawable.a g17 = GuildUrlToDrawable.this.g(option);
                    if (g17 != null && (g16 = g17.g(0.0f)) != null && (k3 = g16.k(ImageView.ScaleType.FIT_XY)) != null) {
                        aVar = k3.h(z16);
                    } else {
                        aVar = null;
                    }
                    if (aVar != null) {
                        QLog.d("GuildUrlToDrawable", 1, "loadSuccess: url=" + this.f111733f + ", " + this.f111734h);
                        aa.b(new Runnable() { // from class: com.tencent.guild.aio.msglist.markdown.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                GuildUrlToDrawable.c.f(h.a.this, aVar);
                            }
                        });
                    }
                    fq0.a aVar4 = fq0.a.f400309a;
                    String localPath = option.getLocalPath();
                    Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
                    aVar4.t(localPath, aVar3);
                }
                list.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.android.androidbypass.enhance.drawable.a g(Option option) {
        Bitmap resultBitMap = option.getResultBitMap();
        Object animatable = option.getAnimatable();
        if (resultBitMap == null && (animatable instanceof Drawable)) {
            resultBitMap = com.tencent.android.androidbypass.enhance.drawable.a.c((Drawable) animatable);
        }
        return com.tencent.android.androidbypass.enhance.drawable.a.d(resultBitMap);
    }

    private final void h(h.a proxy, String url) {
        List<h.a> list = this.mProxyHashMaps.get(url);
        if (list != null) {
            list.add(proxy);
        } else {
            CopyOnWriteArrayList<h.a> copyOnWriteArrayList = new CopyOnWriteArrayList<h.a>() { // from class: com.tencent.guild.aio.msglist.markdown.GuildUrlToDrawable$loadDrawableForBitmapDrawableLagacyProxy$c$1
                public /* bridge */ boolean contains(h.a aVar) {
                    return super.contains((Object) aVar);
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                public /* bridge */ int indexOf(h.a aVar) {
                    return super.indexOf((Object) aVar);
                }

                public /* bridge */ int lastIndexOf(h.a aVar) {
                    return super.lastIndexOf((Object) aVar);
                }

                @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
                public final /* bridge */ h.a remove(int i3) {
                    return removeAt(i3);
                }

                public /* bridge */ h.a removeAt(int i3) {
                    return (h.a) super.remove(i3);
                }

                @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
                public final /* bridge */ int size() {
                    return getSize();
                }

                @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj == null ? true : obj instanceof h.a) {
                        return contains((h.a) obj);
                    }
                    return false;
                }

                @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj == null ? true : obj instanceof h.a) {
                        return indexOf((h.a) obj);
                    }
                    return -1;
                }

                @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj == null ? true : obj instanceof h.a) {
                        return lastIndexOf((h.a) obj);
                    }
                    return -1;
                }

                public /* bridge */ boolean remove(h.a aVar) {
                    return super.remove((Object) aVar);
                }

                @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
                public final /* bridge */ boolean remove(Object obj) {
                    if (obj == null ? true : obj instanceof h.a) {
                        return remove((h.a) obj);
                    }
                    return false;
                }
            };
            copyOnWriteArrayList.add(proxy);
            this.mProxyHashMaps.put(url, copyOnWriteArrayList);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("GuildUrlToDrawable", 1, "startLoadUrl: " + url + "\uff0c " + currentTimeMillis);
        }
        com.tencent.mobileqq.guild.picload.e.a().f(new Option().setRequestHeight((int) (proxy.getIntrinsicHeight() * 0.8f)).setRequestWidth((int) (proxy.getIntrinsicWidth() * 0.8f)).setUrl(url), new c(url, currentTimeMillis, proxy));
    }

    @Override // com.tencent.android.androidbypass.enhance.g
    public void a(@Nullable Context context, @NotNull String url, @NotNull h.b proxy) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        if (QLog.isColorLevel()) {
            QLog.d("GuildUrlToDrawable", 1, "[loadDrawable] url:" + url);
        }
        Option obtain = Option.obtain();
        obtain.setUrl(url);
        h.b.c e16 = proxy.e();
        if (e16 != null) {
            Size size = e16.f72173b;
            if (size != null) {
                obtain.setRequestWidth(size.getWidth());
                obtain.setRequestHeight(size.getHeight());
            }
            ImageView.ScaleType scaleType = e16.f72175d;
            if (e16.f72174c && scaleType != null) {
                obtain.setDecodeMode(1);
                obtain.setRegionScaleType(e16.f72175d);
            }
        }
        com.tencent.mobileqq.guild.picload.e.a().f(obtain, new b(url, proxy, this, context));
    }

    @Override // com.tencent.android.androidbypass.enhance.g
    @Nullable
    public Drawable b(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        return new LoadingDrawable(new com.tencent.android.androidbypass.enhance.drawable.image.b(new WeakReference(context), context.getColor(R.color.qui_common_overlay_light), context.getColor(R.color.qui_common_text_tertiary)));
    }

    @Override // com.tencent.android.androidbypass.enhance.g
    public void c(@Nullable String url, @Nullable h.a proxy) {
        if (url != null && proxy != null) {
            h(proxy, url);
            return;
        }
        QLog.e("GuildUrlToDrawable", 1, "[loadDrawable]: proxy=" + proxy + ", url=" + url);
    }

    @Nullable
    public Drawable f(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        WeakReference weakReference = new WeakReference(context);
        int color = context.getColor(R.color.qui_common_overlay_light);
        int color2 = context.getColor(R.color.qui_common_text_tertiary);
        Drawable drawable = context.getDrawable(R.drawable.j7n);
        Intrinsics.checkNotNull(drawable);
        return new LoadFailedDrawable(new com.tencent.android.androidbypass.enhance.drawable.image.a(weakReference, color, color2, drawable));
    }
}
