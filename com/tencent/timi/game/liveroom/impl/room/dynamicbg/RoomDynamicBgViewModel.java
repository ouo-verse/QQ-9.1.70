package com.tencent.timi.game.liveroom.impl.room.dynamicbg;

import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J5\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J5\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J+\u0010\u0012\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0019\u001a\u00020\u0004R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/dynamicbg/RoomDynamicBgViewModel;", "Landroidx/lifecycle/ViewModel;", "Ltq4/a;", "backgroundInfo", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "callback", "T1", "", "url", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "U1", "S1", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/timi/game/liveroom/impl/room/dynamicbg/a;", "W1", "", "roomId", "X1", "Z1", "i", "Landroid/graphics/Bitmap;", "topBitmap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bottomBitmap", BdhLogUtil.LogTag.Tag_Conn, "Z", "isInRoom", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "bgLiveData", "<init>", "()V", "E", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class RoomDynamicBgViewModel extends ViewModel {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isInRoom;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<RoomDynamicBgData> bgLiveData = new MutableLiveData<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap topBitmap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap bottomBitmap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/dynamicbg/RoomDynamicBgViewModel$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/timi/game/liveroom/impl/room/dynamicbg/RoomDynamicBgViewModel;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.dynamicbg.RoomDynamicBgViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/dynamicbg/RoomDynamicBgViewModel$a$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.liveroom.impl.room.dynamicbg.RoomDynamicBgViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C9936a implements ViewModelProvider.Factory {
            C9936a() {
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
                Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                return modelClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RoomDynamicBgViewModel a(@NotNull ViewModelStoreOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            ViewModel viewModel = new ViewModelProvider(owner, new C9936a()).get(RoomDynamicBgViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner,\u2026cBgViewModel::class.java)");
            return (RoomDynamicBgViewModel) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/dynamicbg/RoomDynamicBgViewModel$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f377562d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Bitmap, Unit> f377563e;

        /* JADX WARN: Multi-variable type inference failed */
        b(String str, Function1<? super Bitmap, Unit> function1) {
            this.f377562d = str;
            this.f377563e = function1;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            AegisLogger.INSTANCE.d("room_info|RoomDynamicBgViewModel", "downloadDrawable, state:" + state + ", url:" + this.f377562d);
            if (state == LoadState.STATE_SUCCESS) {
                this.f377563e.invoke(option.getResultBitMap());
            } else {
                this.f377563e.invoke(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(Function1<? super Boolean, Unit> callback) {
        if (this.topBitmap != null && this.bottomBitmap != null) {
            callback.invoke(Boolean.TRUE);
        } else {
            callback.invoke(Boolean.FALSE);
        }
    }

    private final void T1(tq4.a backgroundInfo, Function1<? super Boolean, Unit> callback) {
        String str;
        String str2;
        if (backgroundInfo != null && (str2 = backgroundInfo.f437140b) != null) {
            U1(str2, new RoomDynamicBgViewModel$downloadBackgroundBitmap$1$1(this, callback));
        }
        if (backgroundInfo != null && (str = backgroundInfo.f437141c) != null) {
            U1(str, new RoomDynamicBgViewModel$downloadBackgroundBitmap$2$1(this, callback));
        }
    }

    private final void U1(String url, Function1<? super Bitmap, Unit> callback) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(url), new b(url, callback));
    }

    private final void a2(tq4.a backgroundInfo) {
        T1(backgroundInfo, new Function1<Boolean, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.dynamicbg.RoomDynamicBgViewModel$showDynamicRoomBg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                boolean z17;
                MutableLiveData mutableLiveData;
                Bitmap bitmap;
                Bitmap bitmap2;
                if (z16) {
                    z17 = RoomDynamicBgViewModel.this.isInRoom;
                    if (z17) {
                        mutableLiveData = RoomDynamicBgViewModel.this.bgLiveData;
                        bitmap = RoomDynamicBgViewModel.this.topBitmap;
                        bitmap2 = RoomDynamicBgViewModel.this.bottomBitmap;
                        mutableLiveData.setValue(new RoomDynamicBgData(bitmap, bitmap2));
                    }
                }
            }
        });
    }

    @NotNull
    public final LiveData<RoomDynamicBgData> W1() {
        return this.bgLiveData;
    }

    public final void X1(long roomId, @Nullable tq4.a backgroundInfo) {
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("room_info|RoomDynamicBgViewModel", "onEnterRoom, roomId:" + roomId);
        this.isInRoom = true;
        if (PadUtil.a(BaseApplication.context) != DeviceType.PHONE) {
            companion.i("room_info|RoomDynamicBgViewModel", "\u4e0d\u662f\u666e\u901a\u8bbe\u5907\uff0c\u4e0d\u5c55\u793a\u80cc\u666f\u76ae\u80a4");
        } else if (ht3.a.e("qqlive_room_dynamic_bg_enable", true)) {
            a2(backgroundInfo);
        }
    }

    public final void Z1() {
        this.isInRoom = false;
    }
}
