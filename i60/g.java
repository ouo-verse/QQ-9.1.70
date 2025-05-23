package i60;

import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends d {
    protected boolean C;

    public g(int i3, List<MultiViewBlock> list, int i16, int i17) {
        super(i3, list, i16, i17);
    }

    @Override // i60.d, i60.b
    public void X6() {
        x9();
        if (this.C) {
            A9(R.drawable.km5);
        } else {
            showLoadingView();
        }
    }
}
