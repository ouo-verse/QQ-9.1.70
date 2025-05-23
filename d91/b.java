package d91;

import com.tencent.freesia.IConfigData;
import e91.i;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends d implements IConfigData {

    /* renamed from: e, reason: collision with root package name */
    private final e91.a f393218e;

    /* renamed from: f, reason: collision with root package name */
    private final i f393219f;

    public b() {
        this("", new e91.a(), new i());
    }

    @Override // d91.d
    public int a() {
        return 186;
    }

    public i c() {
        return this.f393219f;
    }

    public String toString() {
        return "ArkAIKeyWordConfBean{mAiKeywordConfig=" + this.f393218e.toString() + ", mDialogConfig=" + this.f393219f.toString() + '}';
    }

    public b(String str, e91.a aVar, i iVar) {
        super(str);
        this.f393218e = aVar;
        this.f393219f = iVar;
    }
}
