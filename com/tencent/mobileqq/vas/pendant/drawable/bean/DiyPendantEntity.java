package com.tencent.mobileqq.vas.pendant.drawable.bean;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyAddonUser;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes20.dex */
public class DiyPendantEntity extends Entity {
    private static final String TAG = "DiyPendantEntity";
    public int borderId;
    public int diyId;

    @notColumn
    public ArrayList<DiyPendantSticker> stickerList;
    public byte[] stickers;

    @unique
    public String uinAndDiyId;
    public long updateTs;

    private void closeIO(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "close failed", e16);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<DiyPendantSticker> getStickerInfoList() {
        ArrayList<DiyPendantSticker> arrayList;
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream2;
        ArrayList<DiyPendantSticker> arrayList2 = this.stickerList;
        if (arrayList2 != null) {
            return arrayList2;
        }
        if (this.stickers != null) {
            Closeable closeable = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(this.stickers);
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (Exception e16) {
                    e = e16;
                    objectInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    objectInputStream = null;
                }
            } catch (Exception e17) {
                e = e17;
                objectInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                objectInputStream = null;
            }
            try {
                ArrayList<DiyPendantSticker> arrayList3 = (ArrayList) objectInputStream.readObject();
                this.stickerList = arrayList3;
                if (!arrayList3.isEmpty() && !(this.stickerList.get(0) instanceof DiyPendantSticker)) {
                    this.stickerList.clear();
                    try {
                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(this.stickers);
                        try {
                            objectInputStream2 = new ObjectInputStream(byteArrayInputStream2);
                            try {
                                Iterator it = ((ArrayList) objectInputStream2.readObject()).iterator();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    this.stickerList.add(new DiyPendantSticker(((Integer) next.getClass().getField("type").get(next)).intValue(), ((Integer) next.getClass().getField("stickerId").get(next)).intValue(), ((Integer) next.getClass().getField("angle").get(next)).intValue(), (String) next.getClass().getField("text").get(next), ((Integer) next.getClass().getField(MessageForRichState.SIGN_MSG_FONT_ID).get(next)).intValue(), ((Integer) next.getClass().getField(MessageForRichState.SIGN_MSG_FONT_TYPE).get(next)).intValue(), (String) next.getClass().getField("fontColor").get(next)));
                                }
                                closeIO(byteArrayInputStream2);
                            } catch (Exception e18) {
                                e = e18;
                                closeable = byteArrayInputStream2;
                                try {
                                    if (QLog.isColorLevel()) {
                                        QLog.i(TAG, 2, "getStickerInfoList failed 2", e);
                                    }
                                    closeIO(closeable);
                                    closeIO(objectInputStream2);
                                    closeIO(byteArrayInputStream);
                                    closeIO(objectInputStream);
                                    arrayList = this.stickerList;
                                    if (arrayList == null) {
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    closeIO(closeable);
                                    closeIO(objectInputStream2);
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                closeable = byteArrayInputStream2;
                                closeIO(closeable);
                                closeIO(objectInputStream2);
                                throw th;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            objectInputStream2 = null;
                        } catch (Throwable th9) {
                            th = th9;
                            objectInputStream2 = null;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        objectInputStream2 = null;
                    } catch (Throwable th10) {
                        th = th10;
                        objectInputStream2 = null;
                    }
                    closeIO(objectInputStream2);
                }
                closeIO(byteArrayInputStream);
            } catch (Exception e27) {
                e = e27;
                closeable = byteArrayInputStream;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "getStickerInfoList failed 1", e);
                    }
                    closeIO(closeable);
                    closeIO(objectInputStream);
                    arrayList = this.stickerList;
                    if (arrayList == null) {
                    }
                } catch (Throwable th11) {
                    th = th11;
                    closeIO(closeable);
                    closeIO(objectInputStream);
                    throw th;
                }
            } catch (Throwable th12) {
                th = th12;
                closeable = byteArrayInputStream;
                closeIO(closeable);
                closeIO(objectInputStream);
                throw th;
            }
            closeIO(objectInputStream);
        }
        arrayList = this.stickerList;
        if (arrayList == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    public byte[] setStickerInfoList(List<DiyAddonUser.UserStickerInfo> list) {
        if (list != null && !list.isEmpty()) {
            try {
                this.stickerList = new ArrayList<>();
                for (DiyAddonUser.UserStickerInfo userStickerInfo : list) {
                    this.stickerList.add(new DiyPendantSticker(userStickerInfo.type.get(), userStickerInfo.stickerid.get(), userStickerInfo.angle.get(), userStickerInfo.text.get(), userStickerInfo.fontid.get(), userStickerInfo.fonttype.get(), userStickerInfo.fontcolor.get()));
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(this.stickerList);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.stickers = byteArray;
                return byteArray;
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }
}
