package com.tencent.robot.adelie.homepage.create;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.adelie.homepage.create.view.AdelieHeadIconView;
import com.tencent.robot.adelie.homepage.create.view.ImageCategory;
import com.tencent.robot.adelie.homepage.utils.AdelieCroppingUtil;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class AdelieCreationFragment$requestAvatar$1$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ long $startDwonloadTime;
    final /* synthetic */ AdelieCreationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieCreationFragment$requestAvatar$1$1(AdelieCreationFragment adelieCreationFragment, long j3) {
        super(1);
        this.this$0 = adelieCreationFragment;
        this.$startDwonloadTime = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, android.graphics.Bitmap] */
    public static final void b(Bitmap bitmap, final AdelieCreationFragment this$0, long j3) {
        final String Uh;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdelieCroppingUtil.AdelieCroppedImageData e16 = AdelieCroppingUtil.f366635a.e(bitmap);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = e16.getAvatar();
        Bitmap cover = e16.getCover();
        T t16 = objectRef.element;
        if (t16 != 0 && cover != null) {
            objectRef.element = this$0.Jh((Bitmap) t16, 640, 640);
            QLog.w("AdelieCreationFragment", 1, "cuttime: " + (System.currentTimeMillis() - j3));
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$requestAvatar$1$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AdelieCreationFragment.this.lk(true);
                    AdelieHeadIconView Dh = AdelieCreationFragment.this.Dh();
                    if (Dh != null) {
                        Ref.ObjectRef<Bitmap> objectRef2 = objectRef;
                        Dh.setImageCategory(ImageCategory.AI_GENERATE);
                        Dh.i(false);
                        Dh.setBitmap(objectRef2.element);
                    }
                }
            });
            long currentTimeMillis = System.currentTimeMillis();
            final String Uh2 = this$0.Uh((Bitmap) objectRef.element, "adelie_album_avatar");
            if (Uh2 == null || (Uh = this$0.Uh(cover, "adelie_album_bg")) == null) {
                return;
            }
            QLog.w("AdelieCreationFragment", 1, "savetime: " + (System.currentTimeMillis() - currentTimeMillis));
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$requestAvatar$1$1$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AdelieCreationFragment.this.Oh(Uh2, Uh);
                }
            });
            return;
        }
        QLog.w("AdelieCreationFragment", 1, "cropDefaultAvatarAndCoverImage bitmap is isEmpty");
        this$0.lk(false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final Bitmap bitmap) {
        if (bitmap == null) {
            QLog.w("AdelieCreationFragment", 1, "getBitmapFromUrl bitmap is isEmpty");
            this.this$0.lk(false);
            return;
        }
        QLog.w("AdelieCreationFragment", 1, "downloadTime: " + (System.currentTimeMillis() - this.$startDwonloadTime));
        AdelieUtils.f365929a.a0(String.valueOf(this.this$0.getPageType()), 0, "", this.$startDwonloadTime);
        final long currentTimeMillis = System.currentTimeMillis();
        final AdelieCreationFragment adelieCreationFragment = this.this$0;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.ab
            @Override // java.lang.Runnable
            public final void run() {
                AdelieCreationFragment$requestAvatar$1$1.b(bitmap, adelieCreationFragment, currentTimeMillis);
            }
        }, 64, null, true);
    }
}
