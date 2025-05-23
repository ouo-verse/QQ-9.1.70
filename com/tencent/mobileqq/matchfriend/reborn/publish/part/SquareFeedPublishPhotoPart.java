package com.tencent.mobileqq.matchfriend.reborn.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.media.gallery.event.QQStrangerGalleryEvent;
import com.tencent.mobileqq.matchfriend.reborn.publish.SquareFeedPublishHideKeyboardEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import s82.SquarePublishPicInfo;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&0%j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&`'H\u0016R\u0014\u0010+\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R#\u00102\u001a\n -*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R#\u0010<\u001a\n -*\u0004\u0018\u000108088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010/\u001a\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/part/SquareFeedPublishPhotoPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "H9", "", "picPath", "Q9", "S9", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "R9", "I9", "J9", "path", "N9", "D9", "K9", "Landroid/content/Intent;", "data", "P9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "I", "picViewSize", "Ls82/a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "G9", "()Ls82/a;", "viewModel", "Landroid/graphics/drawable/GradientDrawable;", "f", "E9", "()Landroid/graphics/drawable/GradientDrawable;", "emptyPicBg", "Landroid/graphics/drawable/Drawable;", tl.h.F, "F9", "()Landroid/graphics/drawable/Drawable;", "emptyPicIcon", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "i", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "picView", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SquareFeedPublishPhotoPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int picViewSize = com.tencent.qqnt.aio.utils.l.b(100);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy emptyPicBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy emptyPicIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView picView;

    public SquareFeedPublishPhotoPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<s82.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishPhotoPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final s82.a invoke() {
                return (s82.a) SquareFeedPublishPhotoPart.this.getViewModel(s82.a.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishPhotoPart$emptyPicBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GradientDrawable invoke() {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(SquareFeedPublishPhotoPart.this.getContext().getColorStateList(R.color.qui_common_fill_standard_primary));
                return gradientDrawable;
            }
        });
        this.emptyPicBg = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishPhotoPart$emptyPicIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return ie0.a.f().o(SquareFeedPublishPhotoPart.this.getContext(), R.drawable.qui_add_oversized, R.color.qui_common_icon_secondary, 1000);
            }
        });
        this.emptyPicIcon = lazy3;
    }

    private final GradientDrawable E9() {
        return (GradientDrawable) this.emptyPicBg.getValue();
    }

    private final Drawable F9() {
        return (Drawable) this.emptyPicIcon.getValue();
    }

    private final s82.a G9() {
        return (s82.a) this.viewModel.getValue();
    }

    private final void H9() {
        VideoReport.setElementClickPolicy(this.picView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.picView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementId(this.picView, "em_kl_add_picture");
    }

    private final void I9() {
        q82.a aVar = q82.a.f428711a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        aVar.g(activity, 200);
    }

    private final void J9() {
        if (hf0.a.a("SquareFeedPublishPhotoPart")) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(SquareFeedPublishHideKeyboardEvent.INSTANCE);
        SquarePublishPicInfo value = G9().N1().getValue();
        String localPath = value != null ? value.getLocalPath() : null;
        if (localPath == null || localPath.length() == 0) {
            I9();
        } else {
            QLog.i("SquareFeedPublishPhotoPart", 1, "onClickPicView curPath=" + localPath);
            q82.a.e(q82.a.f428711a, getContext(), localPath, this.picView, null, null, false, 56, null);
        }
        Q9(localPath);
    }

    private final void K9() {
        S9();
        G9().N1().postValue(null);
        G9().M1().postValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(SquareFeedPublishPhotoPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void N9(final String path) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.c
            @Override // java.lang.Runnable
            public final void run() {
                SquareFeedPublishPhotoPart.O9(path, this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(String path, SquareFeedPublishPhotoPart this$0) {
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            QLog.i("SquareFeedPublishPhotoPart", 1, "[onSelectPhoto] width=" + options.outWidth + ", height=" + options.outHeight);
            Bitmap D9 = this$0.D9(path);
            if (D9 != null) {
                this$0.G9().N1().postValue(new SquarePublishPicInfo(path));
                this$0.G9().M1().postValue(D9);
            }
            QLog.i("SquareFeedPublishPhotoPart", 1, "onSelectPhoto path=" + path + ", bitmap=" + (D9 != null ? Integer.valueOf(D9.hashCode()) : null));
        } catch (Exception e16) {
            QLog.e("SquareFeedPublishPhotoPart", 1, "decode bitmap error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(Bitmap bitmap) {
        RoundCornerImageView roundCornerImageView = this.picView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        RoundCornerImageView roundCornerImageView2 = this.picView;
        if (roundCornerImageView2 != null) {
            roundCornerImageView2.setImageBitmap(bitmap);
        }
        RoundCornerImageView roundCornerImageView3 = this.picView;
        if (roundCornerImageView3 != null) {
            roundCornerImageView3.setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        RoundCornerImageView roundCornerImageView = this.picView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setScaleType(ImageView.ScaleType.CENTER);
        }
        RoundCornerImageView roundCornerImageView2 = this.picView;
        if (roundCornerImageView2 != null) {
            roundCornerImageView2.setImageDrawable(F9());
        }
        RoundCornerImageView roundCornerImageView3 = this.picView;
        if (roundCornerImageView3 == null) {
            return;
        }
        roundCornerImageView3.setBackground(E9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == -1) {
            P9(data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        MutableLiveData<Bitmap> M1 = G9().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Bitmap, Unit> function1 = new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishPhotoPart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Bitmap bitmap) {
                if (bitmap == null) {
                    SquareFeedPublishPhotoPart.this.S9();
                } else {
                    SquareFeedPublishPhotoPart.this.R9(bitmap);
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SquareFeedPublishPhotoPart.M9(Function1.this, obj);
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QQStrangerGalleryEvent.OnPhotoDeleteEvent) {
            K9();
        } else if (event instanceof QQStrangerGalleryEvent.OnPhotoChangeEvent) {
            N9(((QQStrangerGalleryEvent.OnPhotoChangeEvent) event).getNewPath());
        }
    }

    private final Bitmap D9(String path) {
        int coerceAtMost;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(options.outWidth, options.outHeight);
            int i3 = this.picViewSize;
            if (coerceAtMost > i3) {
                options.inSampleSize = (int) Math.ceil(coerceAtMost / i3);
            }
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(path, options);
        } catch (Exception e16) {
            QLog.e("SquareFeedPublishPhotoPart", 1, "decodeBitmapCenterCrop error", e16);
            return null;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerGalleryEvent.OnPhotoDeleteEvent.class, QQStrangerGalleryEvent.OnPhotoChangeEvent.class);
        return arrayListOf;
    }

    private final void Q9(String picPath) {
        String str;
        Map mapOf;
        if (picPath == null || picPath.length() == 0) {
            str = "0";
        } else {
            str = "1";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_have_picture", str));
        VideoReport.reportEvent("dt_clck", this.picView, mapOf);
    }

    private final void P9(Intent data) {
        Object first;
        Object first2;
        Serializable serializableExtra = data != null ? data.getSerializableExtra("OUTPUT_MEDIA") : null;
        ArrayList arrayList = serializableExtra instanceof ArrayList ? (ArrayList) serializableExtra : null;
        List list = arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null;
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            String str = ((LocalMediaInfo) first).path;
            if (!(str == null || str.length() == 0)) {
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                String path = ((LocalMediaInfo) first2).path;
                Intrinsics.checkNotNullExpressionValue(path, "path");
                N9(path);
                return;
            }
        }
        QLog.i("SquareFeedPublishPhotoPart", 1, "[onWinkPickerResult] outputMedia is null");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        RoundCornerImageView roundCornerImageView = rootView != null ? (RoundCornerImageView) rootView.findViewById(R.id.f163161on0) : null;
        this.picView = roundCornerImageView;
        if (roundCornerImageView != null) {
            roundCornerImageView.setBorder(false);
        }
        RoundCornerImageView roundCornerImageView2 = this.picView;
        if (roundCornerImageView2 != null) {
            roundCornerImageView2.setCorner(com.tencent.qqnt.aio.utils.l.b(4));
        }
        RoundCornerImageView roundCornerImageView3 = this.picView;
        if (roundCornerImageView3 != null) {
            roundCornerImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SquareFeedPublishPhotoPart.L9(SquareFeedPublishPhotoPart.this, view);
                }
            });
        }
        S9();
        H9();
    }
}
