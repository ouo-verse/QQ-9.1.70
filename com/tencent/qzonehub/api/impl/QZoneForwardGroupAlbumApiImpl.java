package com.tencent.qzonehub.api.impl;

import android.content.Context;
import com.qzone.reborn.groupalbum.reship.bean.GroupAIOReshipInitBean;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi;
import cooperation.qzone.model.ForwardGroupAlbumBean;
import cooperation.qzone.model.ForwardMediaInfo;
import ho.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qzonehub/api/impl/QZoneForwardGroupAlbumApiImpl;", "Lcom/tencent/qzonehub/api/IQZoneForwardGroupAlbumApi;", "()V", "tag", "", "forwardToGroupAlbum", "", "data", "Lcooperation/qzone/model/ForwardGroupAlbumBean;", IProfileCardConst.KEY_FROM_TYPE, "", "getMediaType", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", HippyReporter.RemoveEngineReason.INVALID, "invalidMedia", "invalidPic", "mediaInfo", "Lcooperation/qzone/model/ForwardMediaInfo;", "invalidVideo", "isMediaExpired", "msgRecordToMediaInfo", "", "msgRecordList", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class QZoneForwardGroupAlbumApiImpl implements IQZoneForwardGroupAlbumApi {
    private final String tag = "QZoneForwardGroupAlbumApiImpl";

    private final boolean invalid(ForwardGroupAlbumBean data) {
        int i3;
        Context context = data.context;
        List<ForwardMediaInfo> list = data.mediaList;
        if (!(list == null || list.isEmpty()) && context != null) {
            if (data.mediaList.size() > 20) {
                QQToast.makeText(context, context.getString(R.string.f223906hh), 0).show();
                return true;
            }
            Iterator<ForwardMediaInfo> it = data.mediaList.iterator();
            boolean z16 = true;
            boolean z17 = false;
            while (it.hasNext()) {
                ForwardMediaInfo mediaInfo = it.next();
                Intrinsics.checkNotNullExpressionValue(mediaInfo, "mediaInfo");
                if (invalidVideo(mediaInfo) || invalidPic(mediaInfo) || (i3 = mediaInfo.mediaType) == 3 || i3 == 4) {
                    it.remove();
                    z17 = true;
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                QQToast.makeText(context, context.getString(R.string.f223886hf), 0).show();
                return true;
            }
            if (z17) {
                QQToast.makeText(context, context.getString(R.string.f223926hj), 0).show();
            }
            return false;
        }
        QLog.e(this.tag, 1, "data or context is empty");
        return true;
    }

    private final boolean invalidPic(ForwardMediaInfo mediaInfo) {
        int i3 = mediaInfo.mediaType;
        if (i3 != 1 && i3 != 3) {
            return false;
        }
        String str = mediaInfo.filePath;
        return (str == null || str.length() == 0) || mediaInfo.invalidState != 0 || mediaInfo.picSubType != 0 || (System.currentTimeMillis() / ((long) 1000)) - mediaInfo.msgTime >= 2592000;
    }

    private final boolean invalidVideo(ForwardMediaInfo mediaInfo) {
        int i3 = mediaInfo.mediaType;
        if (i3 != 2 && i3 != 4) {
            return false;
        }
        String str = mediaInfo.filePath;
        return (str == null || str.length() == 0) || mediaInfo.invalidState != 0 || (System.currentTimeMillis() / ((long) 1000)) - mediaInfo.msgTime >= JoinTimeType.SEVEN_DAY || mediaInfo.fileSize > 1073741824 || mediaInfo.fileTime > 600;
    }

    @Override // com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi
    public boolean isMediaExpired(MsgRecord record) {
        int mediaType = getMediaType(record);
        if (record == null || mediaType == 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return mediaType != 1 ? mediaType != 2 || currentTimeMillis - record.msgTime >= JoinTimeType.SEVEN_DAY : currentTimeMillis - record.msgTime >= 2592000;
    }

    @Override // com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi
    public List<ForwardMediaInfo> msgRecordToMediaInfo(List<MsgRecord> msgRecordList) {
        ArrayList arrayList = new ArrayList();
        if (msgRecordList != null) {
            for (MsgRecord msgRecord : msgRecordList) {
                ArrayList<MsgElement> arrayList2 = msgRecord.elements;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "record.elements");
                for (MsgElement msgElement : arrayList2) {
                    int i3 = msgElement.elementType;
                    if (i3 == 2) {
                        fj.b bVar = fj.b.f399446a;
                        PicElement picElement = msgElement.picElement;
                        Intrinsics.checkNotNullExpressionValue(picElement, "it.picElement");
                        arrayList.add(bVar.g(picElement, msgRecord.msgTime));
                    } else if (i3 == 5) {
                        fj.b bVar2 = fj.b.f399446a;
                        VideoElement videoElement = msgElement.videoElement;
                        Intrinsics.checkNotNullExpressionValue(videoElement, "it.videoElement");
                        arrayList.add(bVar2.h(videoElement, msgRecord.msgTime));
                    } else if (i3 == 3) {
                        Integer num = msgElement.fileElement.subElementType;
                        if (num != null && num.intValue() == 1) {
                            fj.b bVar3 = fj.b.f399446a;
                            FileElement fileElement = msgElement.fileElement;
                            Intrinsics.checkNotNullExpressionValue(fileElement, "it.fileElement");
                            arrayList.add(bVar3.b(3, fileElement, msgRecord.msgTime, msgRecord));
                        } else {
                            Integer num2 = msgElement.fileElement.subElementType;
                            if (num2 != null && num2.intValue() == 2) {
                                fj.b bVar4 = fj.b.f399446a;
                                FileElement fileElement2 = msgElement.fileElement;
                                Intrinsics.checkNotNullExpressionValue(fileElement2, "it.fileElement");
                                arrayList.add(bVar4.b(4, fileElement2, msgRecord.msgTime, msgRecord));
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi
    public int getMediaType(MsgRecord record) {
        ArrayList<MsgElement> arrayList;
        int i3 = 0;
        if (record != null && (arrayList = record.elements) != null) {
            for (MsgElement msgElement : arrayList) {
                int i16 = msgElement.elementType;
                if (i16 == 2) {
                    i3 = 1;
                } else if (i16 == 5) {
                    i3 = 2;
                } else if (i16 == 3) {
                    Integer num = msgElement.fileElement.subElementType;
                    if (num != null && num.intValue() == 1) {
                        i3 = 3;
                    } else {
                        Integer num2 = msgElement.fileElement.subElementType;
                        if (num2 != null && num2.intValue() == 2) {
                            i3 = 4;
                        }
                    }
                }
            }
        }
        return i3;
    }

    @Override // com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi
    public boolean forwardToGroupAlbum(ForwardGroupAlbumBean data, int fromType) {
        if (data != null) {
            String str = data.groupId;
            if (!(str == null || str.length() == 0)) {
                Context context = data.context;
                if (invalid(data)) {
                    data.context = null;
                    return false;
                }
                if (context != null) {
                    data.context = null;
                    String str2 = data.groupId;
                    Intrinsics.checkNotNull(str2);
                    i.m().g(context, new GroupAIOReshipInitBean(str2, data, fromType));
                }
                return true;
            }
        }
        QLog.e(this.tag, 1, "data or groupId is null");
        return false;
    }

    @Override // com.tencent.qzonehub.api.IQZoneForwardGroupAlbumApi
    public boolean invalidMedia(MsgRecord record) {
        ArrayList arrayListOf;
        if (record == null) {
            return true;
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(record);
        List<ForwardMediaInfo> msgRecordToMediaInfo = msgRecordToMediaInfo(arrayListOf);
        return invalidVideo(msgRecordToMediaInfo.get(0)) || invalidPic(msgRecordToMediaInfo.get(0));
    }
}
