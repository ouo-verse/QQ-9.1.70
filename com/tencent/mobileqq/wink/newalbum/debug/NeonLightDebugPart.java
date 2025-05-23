package com.tencent.mobileqq.wink.newalbum.debug;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.repository.a;
import com.tencent.neonlight.NXServiceManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import e93.QZoneAlbumInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J1\u0010\u0010\u001a\u00020\u00022'\u0010\u000f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/debug/NeonLightDebugPart;", "Lp53/b;", "", "N9", "O9", "D9", "E9", "", "F9", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/ParameterName;", "name", ForwardMiniChooseFriendOption.RESULT_LIST, "completion", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/neonlight/clip/a;", "d", "Lcom/tencent/neonlight/clip/a;", "G9", "()Lcom/tencent/neonlight/clip/a;", "P9", "(Lcom/tencent/neonlight/clip/a;)V", Const.BUNDLE_KEY_REQUEST, "<init>", "()V", "e", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class NeonLightDebugPart extends p53.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.neonlight.clip.a request;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/newalbum/debug/NeonLightDebugPart$b", "Lcom/tencent/mobileqq/wink/picker/core/repository/a$b;", "Le93/j;", "qZoneAlbumInfo", "", "a", "Lcom/tencent/mobileqq/wink/picker/core/repository/b;", "mediaRepoData", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements a.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<List<? extends LocalMediaInfo>, Unit> f324160b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super List<? extends LocalMediaInfo>, Unit> function1) {
            this.f324160b = function1;
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.a.b
        public void a(@NotNull QZoneAlbumInfo qZoneAlbumInfo) {
            Intrinsics.checkNotNullParameter(qZoneAlbumInfo, "qZoneAlbumInfo");
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.a.b
        public void b(@NotNull com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
            List<? extends LocalMediaInfo> list;
            Intrinsics.checkNotNullParameter(mediaRepoData, "mediaRepoData");
            QLog.d(NeonLightDebugPart.this.getTAG(), 1, "getTestMediaInfos, onQueryNextFinish, isSuccess:" + mediaRepoData.getIsSuccess() + ", size:" + mediaRepoData.e().size());
            if (mediaRepoData.getIsSuccess()) {
                Function1<List<? extends LocalMediaInfo>, Unit> function1 = this.f324160b;
                list = CollectionsKt___CollectionsKt.toList(mediaRepoData.e());
                function1.invoke(list);
            }
        }
    }

    private final void D9() {
        H9(new Function1<List<? extends LocalMediaInfo>, Unit>() { // from class: com.tencent.mobileqq.wink.newalbum.debug.NeonLightDebugPart$clipForward$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocalMediaInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<? extends LocalMediaInfo> assets) {
                Intrinsics.checkNotNullParameter(assets, "assets");
                NeonLightDebugPart.this.P9(new com.tencent.neonlight.clip.a());
                com.tencent.neonlight.clip.a request = NeonLightDebugPart.this.getRequest();
                if (request != null) {
                    request.b(assets, new Function4<List<? extends com.tencent.neonlight.clip.b>, com.tencent.neonlight.clip.b, Exception, Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.newalbum.debug.NeonLightDebugPart$clipForward$1.1
                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.neonlight.clip.b> list, com.tencent.neonlight.clip.b bVar, Exception exc, Boolean bool) {
                            invoke((List<com.tencent.neonlight.clip.b>) list, bVar, exc, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull List<com.tencent.neonlight.clip.b> results, @Nullable com.tencent.neonlight.clip.b bVar, @Nullable Exception exc, boolean z16) {
                            Intrinsics.checkNotNullParameter(results, "results");
                            if (exc != null) {
                                QLog.d("NeonLightDebugPart", 4, "\u51fa\u73b0\u9519\u8bef: " + exc.getMessage());
                                return;
                            }
                            QLog.d("NeonLightDebugPart", 4, "\u5904\u7406\u5b8c\u6210\uff0c\u662f\u5426\u7ed3\u675f\uff1a" + z16 + ", \u7ed3\u679c\u6570\u91cf: " + results.size());
                        }
                    });
                }
            }
        });
    }

    private final void E9() {
        com.tencent.neonlight.clip.a aVar = this.request;
        if (aVar != null) {
            aVar.a();
        }
    }

    private final float F9() {
        return NXServiceManager.f337884a.c(new float[1024], new float[1024]);
    }

    private final void H9(Function1<? super List<? extends LocalMediaInfo>, Unit> completion) {
        MediaType mediaType = MediaType.LOCAL_IMAGE;
        MediaFilter.Companion companion = MediaFilter.INSTANCE;
        com.tencent.mobileqq.wink.picker.core.repository.h hVar = new com.tencent.mobileqq.wink.picker.core.repository.h(mediaType, new MediaFilter.a().a());
        hVar.mediaQueryListener = new b(completion);
        com.tencent.mobileqq.wink.picker.core.repository.a.b(hVar, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID, 100, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(NeonLightDebugPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(NeonLightDebugPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(NeonLightDebugPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(NeonLightDebugPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(NeonLightDebugPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N9() {
        NXServiceManager.f337884a.a(NXServiceManager.ModelType.VisualClipSmall, new Function1<Double, Unit>() { // from class: com.tencent.mobileqq.wink.newalbum.debug.NeonLightDebugPart$preDownloadClip$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Double d16) {
                invoke(d16.doubleValue());
                return Unit.INSTANCE;
            }

            public final void invoke(double d16) {
                QLog.d("NeonLightDebugPart", 4, "\u4e0b\u8f7d\u8fdb\u5ea6: " + d16);
            }
        }, new Function2<Boolean, Exception, Unit>() { // from class: com.tencent.mobileqq.wink.newalbum.debug.NeonLightDebugPart$preDownloadClip$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Exception exc) {
                invoke(bool.booleanValue(), exc);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable Exception exc) {
                if (z16) {
                    QLog.d("NeonLightDebugPart", 4, "\u9884\u4e0b\u8f7d\u6210\u529f");
                    return;
                }
                QLog.d("NeonLightDebugPart", 4, "\u9884\u4e0b\u8f7d\u5931\u8d25: " + (exc != null ? exc.getMessage() : null));
            }
        });
    }

    private final void O9() {
        NXServiceManager.f337884a.b(NXServiceManager.ModelType.VisualClipSmall, NXServiceManager.DeviceType.CPU, new Function2<Boolean, Exception, Unit>() { // from class: com.tencent.mobileqq.wink.newalbum.debug.NeonLightDebugPart$preLoadClip$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Exception exc) {
                invoke(bool.booleanValue(), exc);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable Exception exc) {
                if (z16) {
                    QLog.d("NeonLightDebugPart", 4, "\u9884\u52a0\u8f7d\u6210\u529f");
                    return;
                }
                QLog.d("NeonLightDebugPart", 4, "\u9884\u52a0\u8f7d\u5931\u8d25: " + (exc != null ? exc.getMessage() : null));
            }
        });
    }

    @Nullable
    /* renamed from: G9, reason: from getter */
    public final com.tencent.neonlight.clip.a getRequest() {
        return this.request;
    }

    public final void P9(@Nullable com.tencent.neonlight.clip.a aVar) {
        this.request = aVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            rootView.findViewById(R.id.te9).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NeonLightDebugPart.I9(NeonLightDebugPart.this, view);
                }
            });
            rootView.findViewById(R.id.tfb).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NeonLightDebugPart.J9(NeonLightDebugPart.this, view);
                }
            });
            rootView.findViewById(R.id.tdl).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NeonLightDebugPart.K9(NeonLightDebugPart.this, view);
                }
            });
            rootView.findViewById(R.id.tdk).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NeonLightDebugPart.L9(NeonLightDebugPart.this, view);
                }
            });
            rootView.findViewById(R.id.tdm).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.newalbum.debug.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NeonLightDebugPart.M9(NeonLightDebugPart.this, view);
                }
            });
        }
    }
}
