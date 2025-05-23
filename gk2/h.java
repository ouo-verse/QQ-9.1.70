package gk2;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AnimationMode;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TextItem;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.t;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.TextReplaceItem;
import com.tencent.tavcut.composition.model.component.TimeStretchMode;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.videocut.utils.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xd4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000\u001a\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\f*\b\u0012\u0004\u0012\u00020\r0\f\u001a\n\u0010\u0011\u001a\u00020\u0010*\u00020\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel;", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "inputSource", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "b", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/t$b;", "e", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "c", "", "bgPath", "a", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TextItem;", "d", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "f", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f402359a;

        static {
            int[] iArr = new int[AnimationMode.values().length];
            try {
                iArr[AnimationMode.LOOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnimationMode.FREEZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnimationMode.SCALE_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnimationMode.SCALE_BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f402359a = iArr;
        }
    }

    @NotNull
    public static final String a(@NotNull String bgPath) {
        Intrinsics.checkNotNullParameter(bgPath, "bgPath");
        String a16 = k.f384249b.a(bgPath);
        if (a16 != null) {
            return a16;
        }
        return bgPath;
    }

    @NotNull
    public static final Entity b(@NotNull StickerModel stickerModel, @NotNull InputSource inputSource) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        Intrinsics.checkNotNullParameter(inputSource, "inputSource");
        od4.b bVar = od4.b.f422509e;
        xd4.e n3 = bVar.n();
        List<PAGAsset.Replacement> d16 = d(stickerModel.textItems);
        PAGAsset.Replacement c16 = c(stickerModel);
        if (c16 != null) {
            d16 = b.a(d16, c16);
        }
        List<PAGAsset.Replacement> list = d16;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IdentifyComponent(n3.r(stickerModel.centerX, stickerModel.centerY, stickerModel.width, stickerModel.height, stickerModel.scale, stickerModel.rotate)));
        arrayList.add(new IdentifyComponent(n3.a("sticker")));
        String str = inputSource.key;
        if (str == null) {
            str = "";
        }
        arrayList.add(new IdentifyComponent(n3.p(str, 0, list, PAGAsset.PagScaleMode.LETTERBOX)));
        arrayList.add(new IdentifyComponent(n3.e(stickerModel.startTime, stickerModel.duration)));
        arrayList.add(new IdentifyComponent(n3.k(1000)));
        return bVar.p().a("sticker", arrayList);
    }

    @Nullable
    public static final PAGAsset.Replacement c(@NotNull StickerModel stickerModel) {
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        if (!stickerModel.bgConfig.isEmpty()) {
            return new PAGAsset.Replacement(0, a(stickerModel.bgPath), Integer.valueOf(PAGAsset.Replacement.ReplaceType.IMAGE.getValue()), 0, Integer.valueOf(PAGAsset.PagScaleMode.LETTERBOX.getValue()), null, null, null, null, 480, null);
        }
        return null;
    }

    @NotNull
    public static final List<PAGAsset.Replacement> d(@NotNull List<TextItem> list) {
        int collectionSizeOrDefault;
        List<PAGAsset.Replacement> emptyList;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<TextItem> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (TextItem textItem : list2) {
            int i3 = textItem.index;
            String str = textItem.text;
            Boolean bool = textItem.fauxBold;
            Boolean bool2 = textItem.fauxItalic;
            String str2 = textItem.fontFamily;
            Boolean bool3 = textItem.applyStroke;
            float f16 = 100;
            float f17 = (textItem.strokeWidth * 20) / f16;
            com.tencent.videocut.utils.d dVar = com.tencent.videocut.utils.d.f384234a;
            arrayList.add(new PAGAsset.Replacement(Integer.valueOf(i3), str, 1, null, null, Boolean.TRUE, new TextReplaceItem(bool, bool2, str2, null, bool3, dVar.a(textItem.strokeColor), Float.valueOf(f17), textItem.leading, textItem.tracking, dVar.a(textItem.backgroundColor), Integer.valueOf((int) ((textItem.backgroundAlpha / f16) * 255)), dVar.a(textItem.textColor), 1, null, null, null, 57352, null), null, null, 408, null));
        }
        return arrayList;
    }

    @NotNull
    public static final t.RenderData e(@NotNull StickerModel stickerModel) {
        int i3;
        InputSource inputSource;
        Intrinsics.checkNotNullParameter(stickerModel, "<this>");
        xd4.g q16 = od4.b.f422509e.q();
        boolean z16 = false;
        if (a.f402359a[stickerModel.animationMode.ordinal()] == 1) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        InputSource g16 = q16.g(stickerModel.filePath, i3, stickerModel.id, f(stickerModel.animationMode));
        if (stickerModel.bgPath.length() > 0) {
            z16 = true;
        }
        if (z16) {
            inputSource = g.a.a(q16, a(stickerModel.bgPath), stickerModel.bgPath, null, 4, null);
        } else {
            inputSource = null;
        }
        return new t.RenderData(b(stickerModel, g16), g16, inputSource, null, 8, null);
    }

    @NotNull
    public static final TimeStretchMode f(@NotNull AnimationMode animationMode) {
        Intrinsics.checkNotNullParameter(animationMode, "<this>");
        int i3 = a.f402359a[animationMode.ordinal()];
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    return TimeStretchMode.REPEAT;
                }
                return TimeStretchMode.SCALE;
            }
            return TimeStretchMode.SCALE;
        }
        return TimeStretchMode.NONE;
    }
}
