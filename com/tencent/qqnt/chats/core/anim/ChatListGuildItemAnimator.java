package com.tencent.qqnt.chats.core.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.BasePicDownloadProcessor;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.qqnt.chats.core.adapter.holder.GuildDiscoveryItemHolder;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.anim.ChatListGuildItemAnimator;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001f !B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J0\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J8\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0017j\b\u0012\u0004\u0012\u00020\u0002`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/chats/core/anim/ChatListGuildItemAnimator;", "Lcom/tencent/qqnt/chats/core/anim/DefaultItemAnimator;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "e", "", "f", "animateAdd", "animateAddImpl", "", "fromX", "fromY", "toX", "toY", "animateMove", "animateRemove", "oldHolder", "newHolder", "animateChange", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "endAnimation", "endAnimations", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "pendingAdditions", "<init>", "()V", DomainData.DOMAIN_NAME, "AnimationTask", "Companion", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatListGuildItemAnimator extends DefaultItemAnimator {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private static final HashMap<Integer, AnimationTask> f354639o;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RecyclerView.ViewHolder> pendingAdditions;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/chats/core/anim/ChatListGuildItemAnimator$AnimationTask;", "", "", h.F, "f", "d", "c", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "pendantView", "b", "backgroundView", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "removeSelf", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "drawable", "e", "backgroundDrawable", "", "Z", "isCancel", "<init>", "(Landroid/widget/ImageView;Landroid/widget/ImageView;Lkotlin/jvm/functions/Function0;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class AnimationTask {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView pendantView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView backgroundView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<Unit> removeSelf;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private FastDynamicDrawable drawable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private FastDynamicDrawable backgroundDrawable;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean isCancel;

        public AnimationTask(@NotNull ImageView pendantView, @NotNull ImageView backgroundView, @NotNull Function0<Unit> removeSelf) {
            Intrinsics.checkNotNullParameter(pendantView, "pendantView");
            Intrinsics.checkNotNullParameter(backgroundView, "backgroundView");
            Intrinsics.checkNotNullParameter(removeSelf, "removeSelf");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, pendantView, backgroundView, removeSelf);
                return;
            }
            this.pendantView = pendantView;
            this.backgroundView = backgroundView;
            this.removeSelf = removeSelf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(AnimationTask this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this$0.isCancel) {
                this$0.removeSelf.invoke();
                FastDynamicDrawable fastDynamicDrawable = this$0.drawable;
                if (fastDynamicDrawable != null) {
                    fastDynamicDrawable.stop();
                }
                this$0.pendantView.setImageDrawable(null);
                this$0.backgroundView.setImageDrawable(null);
            }
        }

        private final void f() {
            this.backgroundView.setAlpha(1.0f);
            FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k("https://downv6.qq.com/innovate/guild/Test/vashzhong/guild_avatar_anim_bg.png").l(a.f354647a).h(ChatListGuildItemAnimator$AnimationTask$startBackgroundAnimator$1.INSTANCE).a();
            this.backgroundDrawable = a16;
            this.backgroundView.setImageDrawable(a16);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.chats.core.anim.b
                @Override // java.lang.Runnable
                public final void run() {
                    ChatListGuildItemAnimator.AnimationTask.g(ChatListGuildItemAnimator.AnimationTask.this);
                }
            }, 900L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(AnimationTask this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this$0.isCancel) {
                this$0.backgroundView.animate().alpha(0.0f).setDuration(200L).start();
            }
        }

        private final void h() {
            this.pendantView.setScaleType(ImageView.ScaleType.FIT_XY);
            FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k("https://downv6.qq.com/innovate/guild/Test/vashzhong/test_anim_2023.png").l(a.f354647a).h(ChatListGuildItemAnimator$AnimationTask$startPendantAnimator$1.INSTANCE).a();
            this.drawable = a16;
            this.pendantView.setImageDrawable(a16);
        }

        public final void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.isCancel = true;
            }
        }

        public final void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            h();
            f();
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.chats.core.anim.a
                @Override // java.lang.Runnable
                public final void run() {
                    ChatListGuildItemAnimator.AnimationTask.e(ChatListGuildItemAnimator.AnimationTask.this);
                }
            }, 1100L);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0012`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/chats/core/anim/ChatListGuildItemAnimator$Companion;", "", "Lnw3/c;", "imageView", "", "b", "", "key", "Landroid/widget/ImageView;", "pendantView", "backgroundView", "c", "", "IMAGE_BACKGROUND_URL", "Ljava/lang/String;", "IMAGE_URL", "TAG", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/chats/core/anim/ChatListGuildItemAnimator$AnimationTask;", "Lkotlin/collections/HashMap;", "hashMap", "Ljava/util/HashMap;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(nw3.c imageView) {
            FrameLayout frameLayout;
            ViewParent parent = imageView.getAvatarLayout().getParent();
            if (parent instanceof FrameLayout) {
                frameLayout = (FrameLayout) parent;
            } else {
                frameLayout = null;
            }
            if (frameLayout == null) {
                return;
            }
            KeyEvent.Callback findViewById = frameLayout.findViewById(R.id.f165597wv2);
            KeyEvent.Callback callback = findViewById;
            if (findViewById == null) {
                ImageView imageView2 = new ImageView(frameLayout.getContext());
                imageView2.setId(R.id.f165597wv2);
                imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                frameLayout.addView(imageView2, new FrameLayout.LayoutParams(-1, -1));
                callback = imageView2;
            }
            ImageView imageView3 = (ImageView) frameLayout.findViewById(R.id.f165598wv3);
            QLog.i("ChatListGuildItemAnimator", 1, "loadAnimator: " + imageView);
            if (imageView3 == null) {
                return;
            }
            int hashCode = imageView.hashCode();
            AnimationTask animationTask = (AnimationTask) ChatListGuildItemAnimator.f354639o.get(Integer.valueOf(hashCode));
            if (animationTask == null) {
                c(hashCode, (ImageView) callback, imageView3);
                return;
            }
            animationTask.c();
            QLog.i("ChatListGuildItemAnimator", 1, "remove: " + hashCode + ", by cancel");
            c(hashCode, (ImageView) callback, imageView3);
        }

        private final void c(final int key, ImageView pendantView, ImageView backgroundView) {
            AnimationTask animationTask = new AnimationTask(pendantView, backgroundView, new Function0<Unit>(key) { // from class: com.tencent.qqnt.chats.core.anim.ChatListGuildItemAnimator$Companion$startNewTask$task$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $key;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$key = key;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, key);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ChatListGuildItemAnimator.f354639o.remove(Integer.valueOf(this.$key));
                    QLog.i("ChatListGuildItemAnimator", 1, "startNewTask remove: " + this.$key);
                }
            });
            ChatListGuildItemAnimator.f354639o.put(Integer.valueOf(key), animationTask);
            animationTask.d();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chats/core/anim/ChatListGuildItemAnimator$a;", "Lcom/tencent/cachedrawable/dynamicdrawable/api/a$b;", "", "type", "a", "url", "getCacheFilePath", "Ljava/io/File;", "b", "Ljava/io/File;", "EXT_ROOT_DIR", "c", "Ljava/lang/String;", "INNER_ROOT_DIR", "d", "DRAWABLE_DIR", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f354647a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private static final File EXT_ROOT_DIR;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final String INNER_ROOT_DIR;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final String DRAWABLE_DIR;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45756);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            f354647a = new a();
            File externalFilesDir = BaseApplication.getContext().getExternalFilesDir("qqguild");
            EXT_ROOT_DIR = externalFilesDir;
            String absolutePath = BaseApplication.getContext().getFilesDir().getAbsolutePath();
            String str = File.separator;
            String str2 = absolutePath + str + "qqguild" + str;
            INNER_ROOT_DIR = str2;
            if (externalFilesDir != null) {
                DRAWABLE_DIR = externalFilesDir.getAbsolutePath() + str;
                return;
            }
            DRAWABLE_DIR = str2;
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final String a(String type) {
            return DRAWABLE_DIR + type + File.separator;
        }

        @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.b
        @NotNull
        public String getCacheFilePath(@NotNull String url) {
            boolean endsWith$default;
            boolean endsWith$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            }
            Intrinsics.checkNotNullParameter(url, "url");
            if (TextUtils.isEmpty(url) || !new File(url).exists()) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(url, "avif", false, 2, null);
                if (!endsWith$default) {
                    endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(url, "png", false, 2, null);
                    if (endsWith$default2) {
                        return a("cache") + url.hashCode() + ".png";
                    }
                    return a("cache") + url.hashCode();
                }
                return a("cache") + url.hashCode() + BasePicDownloadProcessor.AVIF_FILE_SUFFIX;
            }
            return url;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/chats/core/anim/ChatListGuildItemAnimator$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f354652e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f354653f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f354654h;

        b(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f354652e = viewHolder;
            this.f354653f = view;
            this.f354654h = viewPropertyAnimator;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatListGuildItemAnimator.this, viewHolder, view, viewPropertyAnimator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f354653f.setAlpha(1.0f);
            this.f354653f.setScaleX(1.0f);
            this.f354653f.setScaleY(1.0f);
            QLog.i("ChatListGuildItemAnimator", 1, "addImpl cancel: " + this.f354652e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                return;
            }
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f354653f.setAlpha(1.0f);
            this.f354653f.setScaleX(1.0f);
            this.f354653f.setScaleY(1.0f);
            QLog.i("ChatListGuildItemAnimator", 1, "addImpl end: " + this.f354652e);
            this.f354654h.setListener(null);
            ChatListGuildItemAnimator.this.dispatchAddFinished(this.f354652e);
            ChatListGuildItemAnimator.this.f354663h.remove(this.f354652e);
            ChatListGuildItemAnimator.this.dispatchFinishedWhenDone();
            RecyclerView.ViewHolder viewHolder = this.f354652e;
            Intrinsics.checkNotNull(viewHolder, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder");
            nw3.a a16 = ((RecentContactItemHolder) viewHolder).y().a();
            if (a16 instanceof nw3.c) {
                ChatListGuildItemAnimator.INSTANCE.b((nw3.c) a16);
                return;
            }
            QLog.i("ChatListGuildItemAnimator", 1, "addImpl end: not IRecentAvatarViewWrapper " + a16 + ", " + this.f354652e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            } else {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ChatListGuildItemAnimator.this.dispatchAddStarting(this.f354652e);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45769);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
            f354639o = new HashMap<>();
        }
    }

    public ChatListGuildItemAnimator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.pendingAdditions = new ArrayList<>();
        }
    }

    private final void e(RecyclerView.ViewHolder holder) {
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        ViewPropertyAnimator animate = view.animate();
        this.pendingAdditions.remove(holder);
        this.f354663h.add(holder);
        animate.alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(getAddDuration()).setListener(new b(holder, view, animate)).start();
    }

    private final boolean f(RecyclerView.ViewHolder viewHolder) {
        if (((viewHolder instanceof RecentContactItemHolder) && ((RecentContactItemHolder) viewHolder).A()) || (viewHolder instanceof GuildDiscoveryItemHolder)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.core.anim.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) holder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof RecentContactItemHolder) {
            RecentContactItemHolder recentContactItemHolder = (RecentContactItemHolder) holder;
            if (recentContactItemHolder.B()) {
                super.animateAdd(holder);
                View avatarLayout = recentContactItemHolder.y().a().getAvatarLayout();
                View view = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                Rect c16 = com.tencent.aio.view_dsl.dsl.c.c(avatarLayout, view);
                QLog.i("ChatListGuildItemAnimator", 1, "animateAdd: " + holder.itemView.getMeasuredWidth() + " " + holder.itemView.getMeasuredHeight() + " rect=" + c16 + " " + c16.centerX() + " " + c16.centerY() + " " + holder);
                this.pendingAdditions.add(holder);
                holder.itemView.setPivotX(((float) (c16.left + c16.right)) / 2.0f);
                holder.itemView.setPivotY(((float) (c16.top + c16.bottom)) / 2.0f);
                holder.itemView.setScaleX(0.2f);
                holder.itemView.setScaleY(0.2f);
                return true;
            }
        }
        QLog.i("ChatListGuildItemAnimator", 1, "animateAdd: fallback " + holder + ", reset item");
        dispatchAddFinished(holder);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.chats.core.anim.DefaultItemAnimator
    public void animateAddImpl(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof RecentContactItemHolder) {
            QLog.i("ChatListGuildItemAnimator", 1, "animateAddImpl: subscribe " + holder);
            e(holder);
            return;
        }
        QLog.i("ChatListGuildItemAnimator", 1, "animateAddImpl: fallback " + holder);
        holder.itemView.setScaleX(1.0f);
        holder.itemView.setScaleY(1.0f);
        super.animateAddImpl(holder);
    }

    @Override // com.tencent.qqnt.chats.core.anim.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(@NotNull RecyclerView.ViewHolder oldHolder, @NotNull RecyclerView.ViewHolder newHolder, int fromX, int fromY, int toX, int toY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, oldHolder, newHolder, Integer.valueOf(fromX), Integer.valueOf(fromY), Integer.valueOf(toX), Integer.valueOf(toY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(oldHolder, "oldHolder");
        Intrinsics.checkNotNullParameter(newHolder, "newHolder");
        if (Intrinsics.areEqual(oldHolder, newHolder)) {
            QLog.i("ChatListGuildItemAnimator", 1, "animateChange: same holder " + oldHolder + " " + newHolder);
            return animateMove(oldHolder, fromX, fromY, toX, toY);
        }
        QLog.i("ChatListGuildItemAnimator", 1, "animateChange: " + oldHolder + " " + newHolder);
        if (!f(oldHolder) && !f(newHolder)) {
            dispatchChangeFinished(oldHolder, true);
            dispatchChangeFinished(newHolder, false);
            return false;
        }
        return super.animateChange(oldHolder, newHolder, fromX, fromY, toX, toY);
    }

    @Override // com.tencent.qqnt.chats.core.anim.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(@NotNull RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, holder, Integer.valueOf(fromX), Integer.valueOf(fromY), Integer.valueOf(toX), Integer.valueOf(toY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.i("ChatListGuildItemAnimator", 1, "animateMove: " + holder + " " + fromX + " " + fromY + " " + toX + " " + toY);
        if (GuildLayoutManager.f354256a.n() != 0 && f(holder)) {
            return super.animateMove(holder, fromX, fromY, toX, toY);
        }
        dispatchMoveFinished(holder);
        return false;
    }

    @Override // com.tencent.qqnt.chats.core.anim.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.i("ChatListGuildItemAnimator", 1, "animateRemove: " + holder);
        if (GuildLayoutManager.f354256a.n() != 0 && (holder instanceof RecentContactItemHolder) && ((RecentContactItemHolder) holder).B()) {
            return super.animateRemove(holder);
        }
        dispatchRemoveFinished(holder);
        return false;
    }

    @Override // com.tencent.qqnt.chats.core.anim.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(@NotNull RecyclerView.ViewHolder item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        super.endAnimation(item);
        QLog.i("ChatListGuildItemAnimator", 1, "endAnimation: " + item + " " + this.pendingAdditions.contains(item));
        if (this.pendingAdditions.remove(item)) {
            View view = item.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "item.itemView");
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        }
    }

    @Override // com.tencent.qqnt.chats.core.anim.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.endAnimations();
        QLog.i("ChatListGuildItemAnimator", 1, "endAnimations: " + this.pendingAdditions);
        Iterator<RecyclerView.ViewHolder> it = this.pendingAdditions.iterator();
        while (it.hasNext()) {
            View view = it.next().itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        }
    }
}
