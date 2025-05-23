package po0;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import po0.i;

/* compiled from: P */
/* loaded from: classes6.dex */
public class j implements i.b<IGProUserInfo> {

    /* renamed from: a, reason: collision with root package name */
    private IGProUserInfo f426608a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f426609b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(IGProUserInfo iGProUserInfo) {
        this.f426608a = iGProUserInfo;
    }

    @Override // po0.i.b
    public Drawable a() {
        return this.f426609b;
    }

    @Override // po0.i.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IGProUserInfo getData() {
        return this.f426608a;
    }

    public void c(Drawable drawable) {
        this.f426609b = drawable;
    }

    @Override // po0.i.b
    public String getId() {
        return this.f426608a.getTinyId();
    }

    @Override // po0.i.b
    public CharSequence getText() {
        return this.f426608a.getName();
    }
}
