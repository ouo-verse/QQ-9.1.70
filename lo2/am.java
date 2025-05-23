package lo2;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItemGroup;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class am extends m {

    /* renamed from: b0, reason: collision with root package name */
    private String f415170b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f415171c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f415172d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f415173e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f415174f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f415175g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f415176h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f415177i0;

    public am(String str, long j3, List<String> list, UfsResultItem ufsResultItem, int i3, UfsResultItemGroup ufsResultItemGroup) {
        super(str, j3, list, ufsResultItem, i3);
        this.f415174f0 = false;
        this.f415177i0 = ufsResultItemGroup.groupName;
        d0(ufsResultItem, ufsResultItemGroup);
    }

    private void d0(UfsResultItem ufsResultItem, UfsResultItemGroup ufsResultItemGroup) {
        i0(ufsResultItem.layoutId);
        e0(null);
        int i3 = ufsResultItemGroup.groupExtraFlag;
        boolean z16 = true;
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        g0(z16);
    }

    @Override // lo2.m
    public boolean N() {
        return true;
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        this.f415170b0 = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f415176h0 = new JSONObject(this.f415170b0).getInt("appid");
        } catch (JSONException e16) {
            QLog.e(m.f415228a0, 2, "parseLayoutExtensions exception:" + e16);
        }
    }

    public int W() {
        return this.f415176h0;
    }

    public String X() {
        return this.f415171c0;
    }

    public String Y() {
        return this.f415172d0;
    }

    public String Z() {
        return this.f415170b0;
    }

    public int a0() {
        return this.f415173e0;
    }

    public int b0() {
        return this.f415175g0;
    }

    public boolean c0() {
        return this.f415174f0;
    }

    public void e0(String str) {
        this.f415171c0 = str;
    }

    public void f0(String str) {
        this.f415172d0 = str;
    }

    public void g0(boolean z16) {
        this.f415174f0 = z16;
        V(z16);
    }

    public void i0(int i3) {
        this.f415173e0 = i3;
    }

    public void j0(int i3) {
        this.f415175g0 = i3;
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        return this.f415177i0;
    }
}
