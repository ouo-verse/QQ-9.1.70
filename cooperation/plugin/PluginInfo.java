package cooperation.plugin;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;

/* loaded from: classes28.dex */
public class PluginInfo extends PluginBaseInfo {

    /* renamed from: d, reason: collision with root package name */
    public static final String f390234d = HardCodeUtil.qqStr(R.string.p_7);

    /* renamed from: e, reason: collision with root package name */
    public static final String f390235e = HardCodeUtil.qqStr(R.string.p_6);

    /* renamed from: f, reason: collision with root package name */
    public static final String f390236f = HardCodeUtil.qqStr(R.string.p9v);

    /* renamed from: h, reason: collision with root package name */
    public static final String f390237h = HardCodeUtil.qqStr(R.string.p9y);

    /* renamed from: i, reason: collision with root package name */
    public static final String f390238i = HardCodeUtil.qqStr(R.string.p_0);

    /* renamed from: m, reason: collision with root package name */
    public static final String f390239m = HardCodeUtil.qqStr(R.string.p_2);
    public static final String C = HardCodeUtil.qqStr(R.string.p_4);
    public static final String D = HardCodeUtil.qqStr(R.string.p_1);
    public static final String E = HardCodeUtil.qqStr(R.string.p_8);
    public static final String F = HardCodeUtil.qqStr(R.string.p9u);
    public static final String G = HardCodeUtil.qqStr(R.string.p9x);
    public static final String H = HardCodeUtil.qqStr(R.string.p_3);

    @Override // com.tencent.mobileqq.pluginsdk.PluginBaseInfo
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PluginInfo mo210clone() {
        return (PluginInfo) super.mo210clone();
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginBaseInfo
    public String toString() {
        return "PluginInfo{mID='" + this.mID + "', mName='" + this.mName + "', mVersion='" + this.mVersion + "', mURL='" + this.mURL + "', mMD5='" + this.mMD5 + "', mLength=" + this.mLength + ", mType=" + this.mType + ", mSubType=" + this.mSubType + '}';
    }
}
