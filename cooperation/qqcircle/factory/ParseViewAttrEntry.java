package cooperation.qqcircle.factory;

/* loaded from: classes28.dex */
public class ParseViewAttrEntry {
    public String mAttributeName;
    public String mAttributeValue;
    public IQFSViewAttrParse mViewAttrParse;

    public ParseViewAttrEntry(String str, String str2, IQFSViewAttrParse iQFSViewAttrParse) {
        this.mAttributeName = str;
        this.mAttributeValue = str2;
        this.mViewAttrParse = iQFSViewAttrParse;
    }

    public static ParseViewAttrEntry generate(String str, String str2, IQFSViewAttrParse iQFSViewAttrParse) {
        return new ParseViewAttrEntry(str, str2, iQFSViewAttrParse);
    }
}
