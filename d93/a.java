package d93;

import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaMimeType;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {
    public static String a(MediaFilter mediaFilter) {
        if (mediaFilter == null) {
            return "_size>0 and (mime_type='image/jpeg' or (mime_type='*/*' and _display_name LIKE'%.jpeg%' )  or (mime_type='*/*' and _display_name LIKE'%.jpg%' ) )";
        }
        StringBuilder sb5 = new StringBuilder("_size>0");
        if (mediaFilter.getImageSizeBytesLimit() != Long.MAX_VALUE) {
            sb5.append(" and ");
            sb5.append("_size");
            sb5.append("<");
            sb5.append(mediaFilter.getImageSizeBytesLimit());
        }
        if (mediaFilter.getImageMinWidth() > 0) {
            sb5.append(" and (");
            sb5.append("width");
            sb5.append(">");
            sb5.append(mediaFilter.getImageMinWidth());
            sb5.append(" or ");
            sb5.append("width");
            sb5.append(" IS NULL)");
        }
        if (mediaFilter.getImageMaxWidth() != Integer.MAX_VALUE) {
            sb5.append(" and (");
            sb5.append("width");
            sb5.append("<");
            sb5.append(mediaFilter.getImageMaxWidth());
            sb5.append(" or ");
            sb5.append("width");
            sb5.append(" IS NULL)");
        }
        if (mediaFilter.getImageMinHeight() > 0) {
            sb5.append(" and (");
            sb5.append("height");
            sb5.append(">");
            sb5.append(mediaFilter.getImageMinHeight());
            sb5.append(" or ");
            sb5.append("height");
            sb5.append(" IS NULL)");
        }
        if (mediaFilter.getImageMaxHeight() != Integer.MAX_VALUE) {
            sb5.append(" and (");
            sb5.append("height");
            sb5.append("<");
            sb5.append(mediaFilter.getImageMaxHeight());
            sb5.append(" or ");
            sb5.append("height");
            sb5.append(" IS NULL)");
        }
        sb5.append(" and (mime_type='image/jpeg' or (mime_type='*/*' and _display_name LIKE'%.jpeg%' )  or (mime_type='*/*' and _display_name LIKE'%.jpg%' ) ");
        List<MediaMimeType> supportImageType = mediaFilter.getSupportImageType();
        if (supportImageType.contains(MediaMimeType.IMAGE_GIF)) {
            sb5.append(" or mime_type='image/gif' or mime_type='image/gif'");
        }
        if (supportImageType.contains(MediaMimeType.IMAGE_HEIF)) {
            sb5.append(" or mime_type='image/heif' or mime_type='image/heic'");
        }
        if (supportImageType.contains(MediaMimeType.IMAGE_PNG)) {
            sb5.append(" or (mime_type='*/*' and _display_name LIKE'%.png%' )  or mime_type='image/png'");
        }
        if (supportImageType.contains(MediaMimeType.IMAGE_WEBP)) {
            sb5.append(" or mime_type='image/webp'");
        }
        sb5.append(")");
        return sb5.toString();
    }

    public static String b(MediaFilter mediaFilter) {
        if (mediaFilter == null) {
            return "_size>0 and mime_type='video/mp4')";
        }
        StringBuilder sb5 = new StringBuilder("_size>0 and mime_type='video/mp4'");
        if (mediaFilter.getVideoSizeBytesLimit() != Long.MAX_VALUE) {
            sb5.append(" and ");
            sb5.append("_size");
            sb5.append("<");
            sb5.append(mediaFilter.getVideoSizeBytesLimit());
        }
        if (mediaFilter.getVideoMinWidth() > 0) {
            sb5.append(" and (");
            sb5.append("width");
            sb5.append(">");
            sb5.append(mediaFilter.getVideoMinWidth());
            sb5.append(" or ");
            sb5.append("width");
            sb5.append(" IS NULL)");
        }
        if (mediaFilter.getVideoMaxWidth() != Integer.MAX_VALUE) {
            sb5.append(" and (");
            sb5.append("width");
            sb5.append("<");
            sb5.append(mediaFilter.getVideoMaxWidth());
            sb5.append(" or ");
            sb5.append("width");
            sb5.append(" IS NULL)");
        }
        if (mediaFilter.getVideoMinHeight() > 0) {
            sb5.append(" and (");
            sb5.append("height");
            sb5.append(">");
            sb5.append(mediaFilter.getVideoMinHeight());
            sb5.append(" or ");
            sb5.append("height");
            sb5.append(" IS NULL)");
        }
        if (mediaFilter.getVideoMaxHeight() != Integer.MAX_VALUE) {
            sb5.append(" and (");
            sb5.append("height");
            sb5.append("<");
            sb5.append(mediaFilter.getVideoMaxHeight());
            sb5.append(" or ");
            sb5.append("height");
            sb5.append(" IS NULL)");
        }
        if (mediaFilter.getVideoMinDurationMs() > 0) {
            sb5.append(" and (");
            sb5.append("duration");
            sb5.append(">");
            sb5.append(mediaFilter.getVideoMinDurationMs());
        }
        if (mediaFilter.getVideoMaxDurationMs() > 0) {
            sb5.append(" and (");
            sb5.append("duration");
            sb5.append("<");
            sb5.append(mediaFilter.getVideoMaxDurationMs());
        }
        sb5.append(")");
        return sb5.toString();
    }
}
