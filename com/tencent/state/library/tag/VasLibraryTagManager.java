package com.tencent.state.library.tag;

import com.tencent.state.common.tag.DialogTagSetInfo;
import com.tencent.state.library.data.LibraryDataParserKt;
import com.tencent.state.service.IVasLibraryTagService;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import us4.b;
import us4.c;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/library/tag/VasLibraryTagManager;", "", "()V", "TAG", "", "libraryTagCache", "Lcom/tencent/state/common/tag/DialogTagSetInfo;", "tagService", "Lcom/tencent/state/service/IVasLibraryTagService;", QCircleLpReportDc05507.KEY_CLEAR, "", "getTagInfo", "getTagInfosFromServer", "init", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class VasLibraryTagManager {
    private static final String TAG = "VasGetLibraryTagService";
    public static final VasLibraryTagManager INSTANCE = new VasLibraryTagManager();
    private static final IVasLibraryTagService tagService = (IVasLibraryTagService) Square.INSTANCE.getConfig().getRapier().b(IVasLibraryTagService.class);
    private static DialogTagSetInfo libraryTagCache = LibraryTagInfoKt.getDefaultDialogTagSetInfo();

    VasLibraryTagManager() {
    }

    public final DialogTagSetInfo getTagInfo() {
        return libraryTagCache;
    }

    public final void getTagInfosFromServer() {
        tagService.getTagInfos(new b()).a(new com.tencent.rapier.b<c>() { // from class: com.tencent.state.library.tag.VasLibraryTagManager$getTagInfosFromServer$1
            @Override // com.tencent.rapier.b
            public void onFailure(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasGetLibraryTagService", "parse error " + errorCode + TokenParser.SP + errorMessage, null, 4, null);
            }

            @Override // com.tencent.rapier.b
            public void onSuccess(c response) {
                Intrinsics.checkNotNullParameter(response, "response");
                VasLibraryTagManager vasLibraryTagManager = VasLibraryTagManager.INSTANCE;
                VasLibraryTagManager.libraryTagCache = LibraryDataParserKt.toDialogTagSetInfo(response);
            }
        });
    }

    public final void init() {
        getTagInfosFromServer();
    }

    public final void clear() {
        libraryTagCache = null;
    }
}
