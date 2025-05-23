package ln;

import android.view.View;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class n extends m {

    /* renamed from: e, reason: collision with root package name */
    private QZoneNickNameView f415034e;

    /* renamed from: f, reason: collision with root package name */
    private QZoneUserAvatarView f415035f;

    /* JADX WARN: Multi-variable type inference failed */
    private void v() {
        this.f415035f.setUser(Long.parseLong(((bn.f) this.mData).a().user.f430367id.get()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w() {
        this.f415034e.setRichText(((bn.f) this.mData).a().user.nick.get());
        this.f415034e.setMaxLine(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.f fVar, int i3, List<Object> list) {
        v();
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f162781ml4};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f415034e = (QZoneNickNameView) view.findViewById(R.id.f162778ml1);
        this.f415035f = (QZoneUserAvatarView) view.findViewById(R.id.mlp);
    }
}
