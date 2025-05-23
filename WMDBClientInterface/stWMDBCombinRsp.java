package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stWMDBCombinRsp extends JceStruct {
    static ArrayList<stAD> cache_ads;
    static stAndroidPush cache_androidPush;
    static ArrayList<stCategory> cache_categories;
    static stVersions cache_curVersions;
    static stFlashScreen cache_flashScreen;
    static ArrayList<stOpDataItem> cache_opData;
    static stReturns cache_retures;
    static ArrayList<stWatermark> cache_watermarks;
    static ArrayList<stWatermark> cache_watermarksAdv;
    static ArrayList<stWatermark> cache_watermarksInt;
    static ArrayList<stWMResource> cache_wmResources;
    public ArrayList<stAD> ads;
    public stAndroidPush androidPush;
    public ArrayList<stCategory> categories;
    public stVersions curVersions;
    public stFlashScreen flashScreen;
    public ArrayList<stOpDataItem> opData;
    public stReturns retures;
    public ArrayList<stWatermark> watermarks;
    public ArrayList<stWatermark> watermarksAdv;
    public ArrayList<stWatermark> watermarksInt;
    public ArrayList<stWMResource> wmResources;

    public stWMDBCombinRsp() {
        this.curVersions = null;
        this.retures = null;
        this.watermarks = null;
        this.categories = null;
        this.wmResources = null;
        this.flashScreen = null;
        this.androidPush = null;
        this.ads = null;
        this.opData = null;
        this.watermarksInt = null;
        this.watermarksAdv = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_curVersions == null) {
            cache_curVersions = new stVersions();
        }
        this.curVersions = (stVersions) jceInputStream.read((JceStruct) cache_curVersions, 0, true);
        if (cache_retures == null) {
            cache_retures = new stReturns();
        }
        this.retures = (stReturns) jceInputStream.read((JceStruct) cache_retures, 1, true);
        if (cache_watermarks == null) {
            cache_watermarks = new ArrayList<>();
            cache_watermarks.add(new stWatermark());
        }
        this.watermarks = (ArrayList) jceInputStream.read((JceInputStream) cache_watermarks, 2, true);
        if (cache_categories == null) {
            cache_categories = new ArrayList<>();
            cache_categories.add(new stCategory());
        }
        this.categories = (ArrayList) jceInputStream.read((JceInputStream) cache_categories, 3, true);
        if (cache_wmResources == null) {
            cache_wmResources = new ArrayList<>();
            cache_wmResources.add(new stWMResource());
        }
        this.wmResources = (ArrayList) jceInputStream.read((JceInputStream) cache_wmResources, 4, true);
        if (cache_flashScreen == null) {
            cache_flashScreen = new stFlashScreen();
        }
        this.flashScreen = (stFlashScreen) jceInputStream.read((JceStruct) cache_flashScreen, 5, true);
        if (cache_androidPush == null) {
            cache_androidPush = new stAndroidPush();
        }
        this.androidPush = (stAndroidPush) jceInputStream.read((JceStruct) cache_androidPush, 6, true);
        if (cache_ads == null) {
            cache_ads = new ArrayList<>();
            cache_ads.add(new stAD());
        }
        this.ads = (ArrayList) jceInputStream.read((JceInputStream) cache_ads, 7, true);
        if (cache_opData == null) {
            cache_opData = new ArrayList<>();
            cache_opData.add(new stOpDataItem());
        }
        this.opData = (ArrayList) jceInputStream.read((JceInputStream) cache_opData, 8, true);
        if (cache_watermarksInt == null) {
            cache_watermarksInt = new ArrayList<>();
            cache_watermarksInt.add(new stWatermark());
        }
        this.watermarksInt = (ArrayList) jceInputStream.read((JceInputStream) cache_watermarksInt, 9, false);
        if (cache_watermarksAdv == null) {
            cache_watermarksAdv = new ArrayList<>();
            cache_watermarksAdv.add(new stWatermark());
        }
        this.watermarksAdv = (ArrayList) jceInputStream.read((JceInputStream) cache_watermarksAdv, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.curVersions, 0);
        jceOutputStream.write((JceStruct) this.retures, 1);
        jceOutputStream.write((Collection) this.watermarks, 2);
        jceOutputStream.write((Collection) this.categories, 3);
        jceOutputStream.write((Collection) this.wmResources, 4);
        jceOutputStream.write((JceStruct) this.flashScreen, 5);
        jceOutputStream.write((JceStruct) this.androidPush, 6);
        jceOutputStream.write((Collection) this.ads, 7);
        jceOutputStream.write((Collection) this.opData, 8);
        ArrayList<stWatermark> arrayList = this.watermarksInt;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 9);
        }
        ArrayList<stWatermark> arrayList2 = this.watermarksAdv;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 10);
        }
    }

    public stWMDBCombinRsp(stVersions stversions, stReturns streturns, ArrayList<stWatermark> arrayList, ArrayList<stCategory> arrayList2, ArrayList<stWMResource> arrayList3, stFlashScreen stflashscreen, stAndroidPush standroidpush, ArrayList<stAD> arrayList4, ArrayList<stOpDataItem> arrayList5, ArrayList<stWatermark> arrayList6, ArrayList<stWatermark> arrayList7) {
        this.curVersions = stversions;
        this.retures = streturns;
        this.watermarks = arrayList;
        this.categories = arrayList2;
        this.wmResources = arrayList3;
        this.flashScreen = stflashscreen;
        this.androidPush = standroidpush;
        this.ads = arrayList4;
        this.opData = arrayList5;
        this.watermarksInt = arrayList6;
        this.watermarksAdv = arrayList7;
    }
}
