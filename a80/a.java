package a80;

import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import java.nio.ByteBuffer;
import java.util.List;
import org.libpag.PAGFile;
import org.libpag.PAGImage;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface a {
    void a(int i3);

    void b(boolean z16);

    void c(int i3, PAGImage pAGImage, QFSPagAnimView.d dVar);

    void d(boolean z16);

    void e(int i3, int i16, long j3);

    ByteBuffer f(int i3);

    List<Object> g();

    List<PAGFile> h();

    void i(FrameLayout frameLayout, List<Object> list);

    boolean j();

    void k(f fVar);

    void l(boolean z16);

    void setStaticImageMode(boolean z16);

    void stop();
}
