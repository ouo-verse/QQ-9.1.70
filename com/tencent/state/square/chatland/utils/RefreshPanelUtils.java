package com.tencent.state.square.chatland.utils;

import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagFileHandler;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.SimpleSquarePagViewListener;
import com.tencent.state.utils.SquarePagFileUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/chatland/utils/RefreshPanelUtils;", "", "()V", "TAG", "", "bindInfo", "", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "url", "text", "downloadPag", "tagText", "playPag", "path", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class RefreshPanelUtils {
    public static final RefreshPanelUtils INSTANCE = new RefreshPanelUtils();
    private static final String TAG = "RefreshPanelUtils";

    RefreshPanelUtils() {
    }

    public static final /* synthetic */ void access$playPag(RefreshPanelUtils refreshPanelUtils, ISquarePagView iSquarePagView, String str, String str2) {
        refreshPanelUtils.playPag(iSquarePagView, str, str2);
    }

    private final void downloadPag(ISquarePagView pagView, String url, String tagText) {
        SquarePagFileUtils.INSTANCE.downloadPagFile(url, new RefreshPanelUtils$downloadPag$1(url, pagView, tagText));
    }

    public final void playPag(ISquarePagView pagView, String path, final String tagText) {
        pagView.setPagFileHandler(new ISquarePagFileHandler() { // from class: com.tencent.state.square.chatland.utils.RefreshPanelUtils$playPag$1
            @Override // com.tencent.state.square.api.ISquarePagFileHandler
            public void onPagFileLoaded(ISquarePagView squarePagView) {
                String replace$default;
                SquareBaseKt.getSquareLog().d("RefreshPanelUtils", "tagText: " + tagText);
                if (squarePagView != null) {
                    replace$default = StringsKt__StringsJVMKt.replace$default(tagText, RedTouch.NEWLINE_CHAR, "\n", false, 4, (Object) null);
                    squarePagView.replaceTextLayer(0, replace$default, null, Boolean.TRUE);
                }
            }
        });
        pagView.setPagViewListener(new SimpleSquarePagViewListener(TAG));
        pagView.setPagFile(path);
        final WeakReference weakReference = new WeakReference(pagView);
        pagView.preparePagRuntime(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.utils.RefreshPanelUtils$playPag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ISquarePagView iSquarePagView;
                SquareBaseKt.getSquareLog().d("RefreshPanelUtils", "ready:" + z16);
                if (!z16 || (iSquarePagView = (ISquarePagView) weakReference.get()) == null) {
                    return;
                }
                iSquarePagView.playPag(1);
            }
        });
    }

    public final void bindInfo(ISquarePagView pagView, String url, String text) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(text, "text");
        SquareBaseKt.getSquareLog().d(TAG, "bindInfo, url: " + url + ", text: " + text);
        pagView.stop();
        downloadPag(pagView, url, text);
    }
}
