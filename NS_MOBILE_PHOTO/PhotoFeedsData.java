package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cell_id;
import NS_MOBILE_FEEDS.cell_like;
import NS_MOBILE_FEEDS.cell_operation;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PhotoFeedsData extends JceStruct {
    static Album cache_album;
    static ArrayList<Photo> cache_photolist = new ArrayList<>();
    static cell_comm cache_pss_cell_comm;
    static cell_comment cache_pss_cell_comment;
    static cell_id cache_pss_cell_id;
    static cell_like cache_pss_cell_like;
    static cell_operation cache_pss_cell_operation;
    public Album album;
    public int appid;
    public ArrayList<Photo> photolist;
    public cell_comm pss_cell_comm;
    public cell_comment pss_cell_comment;
    public cell_id pss_cell_id;
    public cell_like pss_cell_like;
    public cell_operation pss_cell_operation;

    static {
        cache_photolist.add(new Photo());
        cache_album = new Album();
        cache_pss_cell_comm = new cell_comm();
        cache_pss_cell_id = new cell_id();
        cache_pss_cell_operation = new cell_operation();
        cache_pss_cell_like = new cell_like();
        cache_pss_cell_comment = new cell_comment();
    }

    public PhotoFeedsData() {
        this.appid = 0;
        this.photolist = null;
        this.album = null;
        this.pss_cell_comm = null;
        this.pss_cell_id = null;
        this.pss_cell_operation = null;
        this.pss_cell_like = null;
        this.pss_cell_comment = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.photolist = (ArrayList) jceInputStream.read((JceInputStream) cache_photolist, 1, false);
        this.album = (Album) jceInputStream.read((JceStruct) cache_album, 2, false);
        this.pss_cell_comm = (cell_comm) jceInputStream.read((JceStruct) cache_pss_cell_comm, 3, false);
        this.pss_cell_id = (cell_id) jceInputStream.read((JceStruct) cache_pss_cell_id, 4, false);
        this.pss_cell_operation = (cell_operation) jceInputStream.read((JceStruct) cache_pss_cell_operation, 5, false);
        this.pss_cell_like = (cell_like) jceInputStream.read((JceStruct) cache_pss_cell_like, 6, false);
        this.pss_cell_comment = (cell_comment) jceInputStream.read((JceStruct) cache_pss_cell_comment, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        ArrayList<Photo> arrayList = this.photolist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        Album album = this.album;
        if (album != null) {
            jceOutputStream.write((JceStruct) album, 2);
        }
        cell_comm cell_commVar = this.pss_cell_comm;
        if (cell_commVar != null) {
            jceOutputStream.write((JceStruct) cell_commVar, 3);
        }
        cell_id cell_idVar = this.pss_cell_id;
        if (cell_idVar != null) {
            jceOutputStream.write((JceStruct) cell_idVar, 4);
        }
        cell_operation cell_operationVar = this.pss_cell_operation;
        if (cell_operationVar != null) {
            jceOutputStream.write((JceStruct) cell_operationVar, 5);
        }
        cell_like cell_likeVar = this.pss_cell_like;
        if (cell_likeVar != null) {
            jceOutputStream.write((JceStruct) cell_likeVar, 6);
        }
        cell_comment cell_commentVar = this.pss_cell_comment;
        if (cell_commentVar != null) {
            jceOutputStream.write((JceStruct) cell_commentVar, 7);
        }
    }

    public PhotoFeedsData(int i3, ArrayList<Photo> arrayList, Album album, cell_comm cell_commVar, cell_id cell_idVar, cell_operation cell_operationVar, cell_like cell_likeVar, cell_comment cell_commentVar) {
        this.appid = i3;
        this.photolist = arrayList;
        this.album = album;
        this.pss_cell_comm = cell_commVar;
        this.pss_cell_id = cell_idVar;
        this.pss_cell_operation = cell_operationVar;
        this.pss_cell_like = cell_likeVar;
        this.pss_cell_comment = cell_commentVar;
    }
}
