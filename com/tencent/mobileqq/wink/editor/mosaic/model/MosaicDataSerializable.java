package com.tencent.mobileqq.wink.editor.mosaic.model;

import com.tencent.mobileqq.wink.mosaic.model.MosaicLinePath;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B/\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R+\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicDataSerializable;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicData;", CanvasView.ACTION_RESTORE, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "pathList", "Ljava/util/ArrayList;", "getPathList", "()Ljava/util/ArrayList;", "undoPathList", "resultPath", "Ljava/lang/String;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/wink/mosaic/model/MosaicLinePath;", "<init>", "(Ljava/util/concurrent/CopyOnWriteArrayList;Ljava/util/concurrent/CopyOnWriteArrayList;Ljava/lang/String;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MosaicDataSerializable implements Serializable {
    private static final long serialVersionUID = 5990931234472342757L;

    @NotNull
    private final ArrayList<String> pathList;

    @Nullable
    private final String resultPath;

    @NotNull
    private final ArrayList<String> undoPathList;

    public MosaicDataSerializable(@NotNull CopyOnWriteArrayList<MosaicLinePath> pathList, @NotNull CopyOnWriteArrayList<MosaicLinePath> undoPathList, @Nullable String str) {
        Intrinsics.checkNotNullParameter(pathList, "pathList");
        Intrinsics.checkNotNullParameter(undoPathList, "undoPathList");
        this.pathList = new ArrayList<>();
        this.undoPathList = new ArrayList<>();
        this.resultPath = str;
        Iterator<T> it = pathList.iterator();
        while (true) {
            String str2 = null;
            if (!it.hasNext()) {
                break;
            }
            MosaicLinePath mosaicLinePath = (MosaicLinePath) it.next();
            ArrayList<String> arrayList = this.pathList;
            JSONObject saveEditDraftInfo = mosaicLinePath.saveEditDraftInfo();
            if (saveEditDraftInfo != null) {
                str2 = saveEditDraftInfo.toString();
            }
            arrayList.add(str2);
        }
        for (MosaicLinePath mosaicLinePath2 : undoPathList) {
            ArrayList<String> arrayList2 = this.undoPathList;
            JSONObject saveEditDraftInfo2 = mosaicLinePath2.saveEditDraftInfo();
            arrayList2.add(saveEditDraftInfo2 != null ? saveEditDraftInfo2.toString() : null);
        }
    }

    @NotNull
    public final ArrayList<String> getPathList() {
        return this.pathList;
    }

    @NotNull
    public final MosaicData restore() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        Iterator<T> it = this.pathList.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = new JSONObject((String) it.next());
            MosaicLinePath mosaicLinePath = new MosaicLinePath();
            mosaicLinePath.parseEditDraftInfo(jSONObject);
            copyOnWriteArrayList.add(mosaicLinePath);
        }
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        Iterator<T> it5 = this.undoPathList.iterator();
        while (it5.hasNext()) {
            JSONObject jSONObject2 = new JSONObject((String) it5.next());
            MosaicLinePath mosaicLinePath2 = new MosaicLinePath();
            mosaicLinePath2.parseEditDraftInfo(jSONObject2);
            copyOnWriteArrayList2.add(mosaicLinePath2);
        }
        return new MosaicData(copyOnWriteArrayList, copyOnWriteArrayList2, this.resultPath);
    }

    public /* synthetic */ MosaicDataSerializable(CopyOnWriteArrayList copyOnWriteArrayList, CopyOnWriteArrayList copyOnWriteArrayList2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(copyOnWriteArrayList, copyOnWriteArrayList2, (i3 & 4) != 0 ? null : str);
    }
}
