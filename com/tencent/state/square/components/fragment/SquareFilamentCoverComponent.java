package com.tencent.state.square.components.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.SquareRuntime;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.cache.DiskLruCache;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.data.FilamentDataUtilsKt;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareTroopItem;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.resource.FilamentCoverRecordHelper;
import com.tencent.state.square.resource.FilamentCoverRecorder;
import com.tencent.state.utils.SquareSwitchUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0014\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014J\u001a\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J(\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\nR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareFilamentCoverComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "coverRecorder", "Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "getCoverRecorder", "()Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "coverRecorder$delegate", "Lkotlin/Lazy;", "enableRecordGuest", "", "enableRecordLand", "checkAndDoRecord", "", "mapItem", "Lcom/tencent/state/map/MapItem;", "init", "initialize", "listCoverFormat", "list", "", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onItemRecordCover", "data", "extra", "", "updateAvatarCover", "id", "", "uin", "resource", "Lcom/tencent/state/square/data/Resource;", "needUpload", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFilamentCoverComponent extends SquareBaseComponent {
    private static final int MAX_CACHE_COUNT = 200;
    private static final String TAG = "SquareFilamentAvatarCoverComponent";

    /* renamed from: coverRecorder$delegate, reason: from kotlin metadata */
    private final Lazy coverRecorder;
    private final boolean enableRecordGuest;
    private final boolean enableRecordLand;

    public SquareFilamentCoverComponent() {
        Lazy lazy;
        SquareSwitchUtils squareSwitchUtils = SquareSwitchUtils.INSTANCE;
        this.enableRecordGuest = squareSwitchUtils.enableRecordGuest();
        this.enableRecordLand = squareSwitchUtils.enableRecordLand();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FilamentCoverRecorder>() { // from class: com.tencent.state.square.components.fragment.SquareFilamentCoverComponent$coverRecorder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FilamentCoverRecorder invoke() {
                return new FilamentCoverRecorder();
            }
        });
        this.coverRecorder = lazy;
    }

    private final void checkAndDoRecord(MapItem mapItem) {
        if (mapItem.getIsFromCache()) {
            return;
        }
        if (mapItem instanceof SquareAvatarItem) {
            if (this.enableRecordGuest || ((SquareAvatarItem) mapItem).isMe()) {
                SquareAvatarItem squareAvatarItem = (SquareAvatarItem) mapItem;
                updateAvatarCover(FilamentDataUtilsKt.getFilamentId(mapItem), mapItem.getUin(), squareAvatarItem.getUserResource(), squareAvatarItem.isMe() || SquareSwitchUtils.INSTANCE.enableFilamentCoverRecordGuestUpload());
                return;
            }
            return;
        }
        if (mapItem instanceof ChatLandAvatarItem) {
            if (this.enableRecordLand || ((ChatLandAvatarItem) mapItem).isMe()) {
                ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) mapItem;
                updateAvatarCover(FilamentDataUtilsKt.getFilamentId(mapItem), mapItem.getUin(), chatLandAvatarItem.getUserResource(), chatLandAvatarItem.isMe());
                return;
            }
            return;
        }
        if (mapItem instanceof SquareTroopItem) {
            if (this.enableRecordGuest || ((SquareTroopItem) mapItem).isMe()) {
                SquareTroopItem squareTroopItem = (SquareTroopItem) mapItem;
                updateAvatarCover(FilamentDataUtilsKt.getFilamentId(mapItem), squareTroopItem.getOwnerUin(), squareTroopItem.getUserResource(), squareTroopItem.isMe() || SquareSwitchUtils.INSTANCE.enableFilamentCoverRecordGuestUpload());
            }
        }
    }

    private final FilamentCoverRecorder getCoverRecorder() {
        return (FilamentCoverRecorder) this.coverRecorder.getValue();
    }

    public final void init() {
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareFilamentCoverComponent$init$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                File file = new File(Resource.INSTANCE.getFullCoverCacheDir());
                if (!file.exists()) {
                    file.mkdirs();
                }
                new DiskLruCache(file, 200, null, 4, null).build();
            }
        });
    }

    public final void initialize() {
        init();
    }

    public final void listCoverFormat(List<? extends MapItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            checkAndDoRecord((MapItem) it.next());
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FilamentCoverRecorder coverRecorder = getCoverRecorder();
        if (coverRecorder != null) {
            coverRecorder.onDestroy();
        }
    }

    public final void updateAvatarCover(String id5, String uin, Resource resource, boolean needUpload) {
        RecordType recordType;
        FilamentResource filament;
        Long toUin;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            recordType = RecordType.FILAMENT_NEARBY;
        } else {
            recordType = RecordType.FILAMENT_SQUARE;
        }
        FilamentCoverRecordHelper.INSTANCE.checkAndRecord(getCoverRecorder(), id5, uin, (resource == null || (filament = resource.getFilament()) == null || (toUin = filament.getToUin()) == null) ? null : String.valueOf(toUin.longValue()), resource, needUpload, recordType, new SquareFilamentCoverComponent$updateAvatarCover$1(this, id5));
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemRecordCover(MapItem data, Object extra) {
        if (data != null) {
            SquareBaseKt.getSquareLog().d(TAG, "recordCover: " + FilamentDataUtilsKt.getFilamentId(data));
            checkAndDoRecord(data);
        }
    }
}
