package co2;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.view.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRectImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends xn2.c {
    public b(IFaceDecoder iFaceDecoder, d dVar) {
        super(iFaceDecoder, dVar);
        QLog.i("gameFriInfo.GameFriendSearchResultPresenter", 2, "[GameFriendSearchResultPresenter]");
    }

    @Override // xn2.c, qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        super.a(yVar, cVar);
        if (!(yVar instanceof wn2.d) || !(cVar instanceof c)) {
            return;
        }
        wn2.d dVar = (wn2.d) yVar;
        ((c) cVar).r(dVar.T(), dVar.U());
    }

    @Override // xn2.c, qn2.f, qn2.c
    /* renamed from: i */
    public void c(y yVar, sn2.c cVar) {
        if (yVar instanceof wn2.d) {
            Object n3 = yVar.n(null);
            if (!(n3 instanceof String)) {
                return;
            }
            String str = (String) n3;
            ImageView f16 = cVar.f();
            if (!(f16 instanceof RoundRectImageView)) {
                return;
            }
            RoundRectImageView roundRectImageView = (RoundRectImageView) f16;
            roundRectImageView.setCornerRadiusAndMode(com.tencent.mobileqq.gamecenter.util.a.a(20.0f, roundRectImageView.getResources()), 1);
            roundRectImageView.setImageDrawable(URLDrawable.getDrawable(str));
            return;
        }
        super.c(yVar, cVar);
    }
}
