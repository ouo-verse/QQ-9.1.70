package com.tencent.state.square.api;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007H&J+\u0010\r\u001a\u00020\u000b2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u000fH&J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J5\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010H&\u00a2\u0006\u0002\u0010\u001bJ#\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H&\u00a2\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0007H&J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0005H&J\u0012\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H&J\u0012\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)H&J\b\u0010*\u001a\u00020\u000bH&\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/square/api/ISquarePagView;", "", "getPagView", "Landroid/view/View;", "getTextLayer", "", "layerIndex", "", "getView", "numImages", "playPag", "", "repeatCount", "preparePagRuntime", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "replaceImageLayer", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "replaceTextLayer", "text", "textColor", "bold", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "setLayerVisible", "layers", "", NodeProps.VISIBLE, "([Ljava/lang/Integer;Z)V", "setPagFile", "id", "filePath", "setPagFileHandler", "handler", "Lcom/tencent/state/square/api/ISquarePagFileHandler;", "setPagViewListener", "listener", "Lcom/tencent/state/square/api/ISquarePagViewListener;", "stop", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquarePagView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void playPag$default(ISquarePagView iSquarePagView, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    i3 = 0;
                }
                iSquarePagView.playPag(i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playPag");
        }

        public static /* synthetic */ void replaceTextLayer$default(ISquarePagView iSquarePagView, int i3, String str, String str2, Boolean bool, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    bool = Boolean.FALSE;
                }
                iSquarePagView.replaceTextLayer(i3, str, str2, bool);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceTextLayer");
        }
    }

    @Nullable
    View getPagView();

    @Nullable
    String getTextLayer(int layerIndex);

    @NotNull
    View getView();

    int numImages();

    void playPag(int repeatCount);

    void preparePagRuntime(@NotNull Function1<? super Boolean, Unit> callback);

    boolean replaceImageLayer(int layerIndex, @Nullable Bitmap bitmap);

    void replaceTextLayer(int layerIndex, @Nullable String text, @Nullable String textColor, @Nullable Boolean bold);

    void setLayerVisible(@NotNull Integer[] layers, boolean visible);

    void setPagFile(int id5);

    void setPagFile(@NotNull String filePath);

    void setPagFileHandler(@Nullable ISquarePagFileHandler handler);

    void setPagViewListener(@Nullable ISquarePagViewListener listener);

    void stop();
}
